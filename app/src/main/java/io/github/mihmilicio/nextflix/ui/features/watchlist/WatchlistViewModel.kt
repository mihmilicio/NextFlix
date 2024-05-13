package io.github.mihmilicio.nextflix.ui.features.watchlist

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import io.github.mihmilicio.nextflix.domain.usecase.ListarSeriesNaWatchlistUseCase
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class WatchlistViewModel @Inject constructor(
    private val listarSeriesNaWatchlistUseCase: ListarSeriesNaWatchlistUseCase

) : ViewModel() {

    private val _series = MutableStateFlow<List<DetalheDaSerie>>(emptyList())
    val series: StateFlow<List<DetalheDaSerie>> get() = _series

    init {
        _series.value = listarSeriesNaWatchlistUseCase()
    }
}