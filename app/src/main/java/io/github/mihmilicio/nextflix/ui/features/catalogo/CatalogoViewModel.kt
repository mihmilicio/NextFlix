package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mihmilicio.nextflix.data.Serie
import io.github.mihmilicio.nextflix.domain.catalogo.ListarSeriesPopularesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CatalogoViewModel @Inject constructor(
    private val listarSeriesPopularesUseCase: ListarSeriesPopularesUseCase
) : ViewModel() {

    private val _series = MutableStateFlow(emptyList<Serie>())
    val series: StateFlow<List<Serie>> get() = _series

    init {
        listarSeriesPopulares()
    }

    private fun listarSeriesPopulares() {
        _series.value = listarSeriesPopularesUseCase()
    }
}