package io.github.mihmilicio.nextflix.data.repository

import io.github.mihmilicio.nextflix.data.datasource.WatchlistLocalDataSource
import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import io.github.mihmilicio.nextflix.domain.model.Episodio
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteDeClasse
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteMockito
import io.github.mihmilicio.nextflix.test_utils.mock
import io.github.mihmilicio.nextflix.test_utils.whenever
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.verify

class WatchlistRepositoryTest : SuiteDeTesteMockito, SuiteDeTesteDeClasse<WatchlistRepository> {

    private val watchlistLocalDataSource: WatchlistLocalDataSource = mock()

    override fun instanciar() = WatchlistRepository(watchlistLocalDataSource)

    @Test
    fun adicionarSerieNaWatchlist() {
        val serie = DetalheDaSerie.stub

        val repository = instanciar()
        repository.adicionarSerieNaWatchlist(serie)

        verify(watchlistLocalDataSource).adicionarSerieNaWatchlist(serie)
    }

    @Test
    fun listarSeriesNaWatchlist() {
        val series = listOf(DetalheDaSerie.stub)

        whenever(watchlistLocalDataSource.listarSeriesNaWatchlist()).thenReturn(series)

        val repository = instanciar()

        assertEquals(series, repository.listarSeriesNaWatchlist())
        verify(watchlistLocalDataSource).listarSeriesNaWatchlist()
    }

    @Test
    fun buscarSerieNaWatchlist() {
        val id = 123L
        val serie = DetalheDaSerie.stub

        whenever(watchlistLocalDataSource.buscarSerieNaWatchlist(id)).thenReturn(serie)

        val repository = instanciar()

        assertEquals(serie, repository.buscarSerieNaWatchlist(id))
        verify(watchlistLocalDataSource).buscarSerieNaWatchlist(id)
    }


    @Test
    fun atualizarEpisodioDaSerie() {
        val id = 123L
        val episodio = Episodio.stub

        val repository = instanciar()
        repository.atualizarEpisodioDaSerie(id, episodio)

        verify(watchlistLocalDataSource).atualizarEpisodioDaSerie(id, episodio)
    }
}
