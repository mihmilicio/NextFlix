package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mihmilicio.nextflix.data.Serie
import io.github.mihmilicio.nextflix.domain.catalogo.ListarSeriesPopularesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogoViewModel @Inject constructor(
    private val listarSeriesPopularesUseCase: ListarSeriesPopularesUseCase
) : ViewModel() {

    private val _seriesPaging: MutableStateFlow<PagingData<Serie>> =
        MutableStateFlow(value = PagingData.empty())
    val seriesPaging: StateFlow<PagingData<Serie>> get() = _seriesPaging

    init {
        listarSeriesPopulares()
    }

    // TODO chamar só uma vez
    private fun listarSeriesPopulares() {
        viewModelScope.launch {
            listarSeriesPopularesUseCase()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect { _seriesPaging.value = it }
        }
    }
}