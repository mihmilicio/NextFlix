package io.github.mihmilicio.nextflix.data.datasource

import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteDeClasse
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteMockito
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class WatchlistLocalDataSourceTest : SuiteDeTesteMockito,
    SuiteDeTesteDeClasse<WatchlistLocalDataSource> {

    override fun instanciar() = WatchlistLocalDataSource()

    @Test
    fun adicionarSerieNaWatchlist() {
        val dataSource = instanciar()

        val serie = DetalheDaSerie.stub.copy()
        dataSource.adicionarSerieNaWatchlist(serie)

        assert(dataSource.listarSeriesNaWatchlist().contains(serie))
    }

    @Test
    fun `listar series na watchlist (nao assistidas)`() {
        val dataSource = instanciar()

        val serie1 = DetalheDaSerie.stub.copy()
        dataSource.adicionarSerieNaWatchlist(serie1)

        val serieAssistida = DetalheDaSerie.stubAssistida
        dataSource.adicionarSerieNaWatchlist(serieAssistida)

        val serie3 = DetalheDaSerie.stub.copy()
        dataSource.adicionarSerieNaWatchlist(serie3)

        assertEquals(listOf(serie1, serie3), dataSource.listarSeriesNaWatchlist())
    }

    @Test
    fun `buscar serie na watchlist (nao assistida)`() {
        val dataSource = instanciar()

        val serie1 = DetalheDaSerie.stub.copy()
        dataSource.adicionarSerieNaWatchlist(serie1)

        val serieAssistida = DetalheDaSerie.stubAssistida
        dataSource.adicionarSerieNaWatchlist(serieAssistida)

        assertEquals(serie1, dataSource.buscarSerieNaWatchlist(serie1.id))
    }

    @Test
    fun `buscar serie na watchlist (assistida)`() {
        val dataSource = instanciar()

        val serie1 = DetalheDaSerie.stub.copy()
        dataSource.adicionarSerieNaWatchlist(serie1)

        val serieAssistida = DetalheDaSerie.stubAssistida
        dataSource.adicionarSerieNaWatchlist(serieAssistida)

        assertNull(dataSource.buscarSerieNaWatchlist(serieAssistida.id))
    }

    @Test
    fun `buscar serie na watchlist (inexistente)`() {
        val dataSource = instanciar()

        val serie1 = DetalheDaSerie.stub.copy()
        dataSource.adicionarSerieNaWatchlist(serie1)

        val serieAssistida = DetalheDaSerie.stubAssistida
        dataSource.adicionarSerieNaWatchlist(serieAssistida)

        assertNull(dataSource.buscarSerieNaWatchlist(564546L))
    }

    @Test
    fun `buscar serie assistida (nao assistida)`() {
        val dataSource = instanciar()

        val serie1 = DetalheDaSerie.stub.copy()
        dataSource.adicionarSerieNaWatchlist(serie1)

        val serieAssistida = DetalheDaSerie.stubAssistida
        dataSource.adicionarSerieNaWatchlist(serieAssistida)

        assertNull(dataSource.buscarSerieAssistida(serie1.id))
    }

    @Test
    fun `buscar serie assistida (assistida)`() {
        val dataSource = instanciar()

        val serie1 = DetalheDaSerie.stub.copy()
        dataSource.adicionarSerieNaWatchlist(serie1)

        val serieAssistida = DetalheDaSerie.stubAssistida
        dataSource.adicionarSerieNaWatchlist(serieAssistida)

        assertEquals(serieAssistida, dataSource.buscarSerieAssistida(serieAssistida.id))
    }

    @Test
    fun `buscar serie assistida (inexistente)`() {
        val dataSource = instanciar()

        val serie1 = DetalheDaSerie.stub.copy()
        dataSource.adicionarSerieNaWatchlist(serie1)

        val serieAssistida = DetalheDaSerie.stubAssistida
        dataSource.adicionarSerieNaWatchlist(serieAssistida)

        assertNull(dataSource.buscarSerieAssistida(564546L))
    }

    @Test
    fun atualizarEpisodioDaSerie() {
        val dataSource = instanciar()

        val serie = DetalheDaSerie.stub.copy()
        dataSource.adicionarSerieNaWatchlist(serie)

        val episodioAtualizado = serie.episodios[0].copy(assistido = true)
        dataSource.atualizarEpisodioDaSerie(serie.id, episodioAtualizado)

        assertEquals(
            episodioAtualizado,
            dataSource.buscarSerieAssistida(serie.id)?.episodios!![0]
        )
        assertTrue(dataSource.buscarSerieAssistida(serie.id)!!.assistida)
    }

}