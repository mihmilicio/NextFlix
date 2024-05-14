package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.repository.WatchlistRepository
import io.github.mihmilicio.nextflix.domain.model.SerieParaAssistir
import javax.inject.Inject

class ListarSeriesParaAssistirUseCase @Inject constructor(
    private val watchlistRepository: WatchlistRepository
) {

    operator fun invoke(): List<SerieParaAssistir> = watchlistRepository.listarSeriesNaWatchlist()
        .filter { serie -> (serie.temEpisodiosNaoAssistidos() && !serie.assistida) }
        .map { serie ->
            serie.asSerieParaAssistir()
        }
}