package io.github.mihmilicio.nextflix.domain.usecase

import android.util.Log
import io.github.mihmilicio.nextflix.data.repository.WatchlistRepository
import javax.inject.Inject

class AdicionarSerieNaWatchlistUseCase @Inject constructor(
    private val consultarDetalhesDaSerieUseCase: ConsultarDetalhesDaSerieUseCase,
    private val watchlistRepository: WatchlistRepository
) {

    suspend operator fun invoke(id: Long) {
        val serie = consultarDetalhesDaSerieUseCase(id)
        Log.d("AdicionarSerieNaWatchlistUseCase", "Serie: $serie")
        watchlistRepository.adicionarSerieNaWatchlist(serie)
    }

}