package io.github.mihmilicio.nextflix.ui.features.watchlist

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mihmilicio.nextflix.domain.model.EpisodioDaWatchlist
import io.github.mihmilicio.nextflix.domain.usecase.ListarEpisodiosParaAssistirUseCase
import io.github.mihmilicio.nextflix.domain.usecase.MarcarEpisodioAssistidoUseCase
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class WatchlistViewModel @Inject constructor(
    private val listarEpisodiosParaAssistirUseCase: ListarEpisodiosParaAssistirUseCase,
    private val marcarEpisodioAssistidoUseCase: MarcarEpisodioAssistidoUseCase

) : ViewModel() {

    var episodios = mutableStateListOf<EpisodioDaWatchlist>()

    init {
        episodios.addAll(listarEpisodiosParaAssistirUseCase())
    }

    fun marcarEpisodioAssistido(episodio: EpisodioDaWatchlist) {
        marcarEpisodioAssistidoUseCase(episodio)

        val episodiosAtualizados = listarEpisodiosParaAssistirUseCase()

        val index = episodios.indexOf(episodio)
        episodios[index] = episodiosAtualizados[index]
    }

}