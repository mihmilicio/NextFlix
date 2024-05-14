package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.repository.WatchlistRepository
import io.github.mihmilicio.nextflix.domain.model.EpisodioDaWatchlist
import javax.inject.Inject

class MarcarEpisodioAssistidoUseCase @Inject constructor(
    private val watchlistRepository: WatchlistRepository
) {

    operator fun invoke(episodio: EpisodioDaWatchlist) =
        watchlistRepository.atualizarEpisodioDaSerie(
            serieId = episodio.serie.id,
            episodio = episodio.asEpisodio().copy(assistido = true)
        )
}