package io.github.mihmilicio.nextflix.data.repository

import io.github.mihmilicio.nextflix.data.datasource.WatchlistLocalDataSource
import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import javax.inject.Inject

class WatchlistRepository @Inject constructor(
    private val watchlistLocalDataSource: WatchlistLocalDataSource
) {
    fun adicionarSerieNaWatchlist(serie: DetalheDaSerie) =
        watchlistLocalDataSource.adicionarSerieNaWatchlist(serie)
}