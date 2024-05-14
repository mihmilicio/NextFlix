package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.repository.WatchlistRepository
import io.github.mihmilicio.nextflix.domain.model.SerieParaAssistir
import javax.inject.Inject

class MarcarEpisodioAssistidoUseCase @Inject constructor(
    private val watchlistRepository: WatchlistRepository
) {

    operator fun invoke(serie: SerieParaAssistir) =
        watchlistRepository.atualizarEpisodioDaSerie(
            serieId = serie.id,
            episodio = serie.episodio.copy(assistido = true)
        )
}