package io.github.mihmilicio.nextflix.data.datasource

import android.util.Log
import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import io.github.mihmilicio.nextflix.domain.model.Episodio

class WatchlistLocalDataSource {

    private val watchlist = mutableListOf<DetalheDaSerie>()

    fun adicionarSerieNaWatchlist(serie: DetalheDaSerie) {
        watchlist.add(serie)
        Log.d("WatchlistLocalDataSource", "Serie adicionada na watchlist: ${serie.nome}")
        Log.d("WatchlistLocalDataSource", "Watchlist atualizada: ${watchlist.size}")
    }

    fun listarSeriesNaWatchlist(): List<DetalheDaSerie> {
        return watchlist.filter { !it.assistida }
    }

    fun atualizarEpisodioDaSerie(serieId: Long, episodio: Episodio) {
        watchlist.map { serie ->
            if (serie.id == serieId) {
                serie.atualizarEpisodio(episodio)
            }

            serie
        }
    }

}