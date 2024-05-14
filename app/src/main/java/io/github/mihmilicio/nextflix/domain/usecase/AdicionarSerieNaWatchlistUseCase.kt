package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.repository.WatchlistRepository
import javax.inject.Inject

class AdicionarSerieNaWatchlistUseCase @Inject constructor(
    private val consultarDetalhesDaSerieUseCase: ConsultarDetalhesDaSerieUseCase,
    private val watchlistRepository: WatchlistRepository
) {

    suspend operator fun invoke(id: Long) {
        if (watchlistRepository.buscarSerieNaWatchlist(id) != null) {
            return
        }
        
        val serie = consultarDetalhesDaSerieUseCase(id)
        watchlistRepository.adicionarSerieNaWatchlist(serie)
    }

}