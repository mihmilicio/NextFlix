package io.github.mihmilicio.nextflix.data.datasource

import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import io.github.mihmilicio.nextflix.domain.model.Episodio

class WatchlistLocalDataSource {

    private val watchlist = mutableListOf<DetalheDaSerie>()

    fun adicionarSerieNaWatchlist(serie: DetalheDaSerie) {
        watchlist.add(serie)
    }

    fun listarSeriesNaWatchlist(): List<DetalheDaSerie> {
        return watchlist.filter { !it.assistida }
    }

    fun buscarSerieNaWatchlist(id: Long): DetalheDaSerie? {
        return watchlist.find { it.id == id && !it.assistida }
    }

    fun buscarSerieAssistida(id: Long): DetalheDaSerie? {
        return watchlist.find { it.id == id && it.assistida }
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