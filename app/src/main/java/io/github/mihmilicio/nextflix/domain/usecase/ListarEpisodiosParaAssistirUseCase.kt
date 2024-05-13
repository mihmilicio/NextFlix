package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.repository.WatchlistRepository
import io.github.mihmilicio.nextflix.domain.model.EpisodioDaWatchlist
import javax.inject.Inject

class ListarEpisodiosParaAssistirUseCase @Inject constructor(
    private val watchlistRepository: WatchlistRepository
) {

    operator fun invoke(): List<EpisodioDaWatchlist> =
        watchlistRepository.listarSeriesNaWatchlist()
            .filter { serie -> serie.episodios.isNotEmpty() }
            .map {
                EpisodioDaWatchlist(
                    episodio = it.episodios[0].episodio,
                    temporada = it.episodios[0].temporada,
                    nome = it.episodios[0].nome,
                    foto = it.foto,
                    serie = it.asSerie()
                )
            }
}