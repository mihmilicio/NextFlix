package io.github.mihmilicio.nextflix.ui.features.watchlist

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mihmilicio.nextflix.domain.model.EpisodioDaWatchlist
import io.github.mihmilicio.nextflix.domain.usecase.ListarEpisodiosParaAssistirUseCase
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class WatchlistViewModel @Inject constructor(
    private val listarEpisodiosParaAssistirUseCase: ListarEpisodiosParaAssistirUseCase

) : ViewModel() {

    private val _episodios = MutableStateFlow<List<EpisodioDaWatchlist>>(emptyList())
    val episodios: StateFlow<List<EpisodioDaWatchlist>> get() = _episodios

    init {
        _episodios.value = listarEpisodiosParaAssistirUseCase()
    }
}