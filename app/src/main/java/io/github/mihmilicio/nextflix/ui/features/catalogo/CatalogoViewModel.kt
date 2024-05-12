package io.github.mihmilicio.nextflix.ui.features.catalogo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mihmilicio.nextflix.data.Serie
import io.github.mihmilicio.nextflix.domain.catalogo.ListarSeriesPopularesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
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

    // TODO chamar só uma vez
    private fun listarSeriesPopulares() {
        viewModelScope.launch {
            try {
                val series = listarSeriesPopularesUseCase()
                _series.value = series
            } catch (e: Exception) {
                Log.d("CatalogoViewModel", e.message.toString())
            }
        }
    }
}