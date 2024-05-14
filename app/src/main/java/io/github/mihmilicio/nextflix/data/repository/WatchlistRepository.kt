package io.github.mihmilicio.nextflix.data.repository

import io.github.mihmilicio.nextflix.data.datasource.WatchlistLocalDataSource
import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import io.github.mihmilicio.nextflix.domain.model.Episodio
import javax.inject.Inject

class WatchlistRepository @Inject constructor(
    private val watchlistLocalDataSource: WatchlistLocalDataSource
) {
    fun adicionarSerieNaWatchlist(serie: DetalheDaSerie) =
        watchlistLocalDataSource.adicionarSerieNaWatchlist(serie)

    fun listarSeriesNaWatchlist() = watchlistLocalDataSource.listarSeriesNaWatchlist()

    fun atualizarEpisodioDaSerie(serieId: Long, episodio: Episodio) =
        watchlistLocalDataSource.atualizarEpisodioDaSerie(
            serieId,
            episodio
        )
}