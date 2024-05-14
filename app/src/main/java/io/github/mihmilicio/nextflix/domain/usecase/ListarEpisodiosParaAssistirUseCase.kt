package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.repository.WatchlistRepository
import io.github.mihmilicio.nextflix.domain.model.EpisodioDaWatchlist
import javax.inject.Inject

class ListarEpisodiosParaAssistirUseCase @Inject constructor(
    private val watchlistRepository: WatchlistRepository
) {

    operator fun invoke(): List<EpisodioDaWatchlist> = watchlistRepository.listarSeriesNaWatchlist()
        .filter { serie -> (serie.episodios.isNotEmpty() && serie.episodios.any { !it.assistido }) }
        .map { serie ->
            val primeiroEpisodioPendente = serie.episodios.first { !it.assistido }
            EpisodioDaWatchlist(
                episodio = primeiroEpisodioPendente.episodio,
                temporada = primeiroEpisodioPendente.temporada,
                nome = primeiroEpisodioPendente.nome,
                foto = serie.foto,
                serie = serie.asSerie()
            )
        }
}