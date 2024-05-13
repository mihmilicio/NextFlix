package io.github.mihmilicio.nextflix.domain.usecase

import android.util.Log
import javax.inject.Inject

class AdicionarSerieNaWatchlistUseCase @Inject constructor(
    private val consultarDetalhesDaSerieUseCase: ConsultarDetalhesDaSerieUseCase
) {

    suspend operator fun invoke(id: Long) {
        val serie = consultarDetalhesDaSerieUseCase(id)
        Log.d("AdicionarSerieNaWatchlistUseCase", "Serie: $serie")
    }

}