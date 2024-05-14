package io.github.mihmilicio.nextflix.data.repository

import io.github.mihmilicio.nextflix.data.datasource.SerieRemoteDataSource
import io.github.mihmilicio.nextflix.data.dto.ListagemDeSeriesDto
import io.github.mihmilicio.nextflix.data.dto.RespostaDetalheDaSerieDto
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteDeClasse
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteMockito
import io.github.mihmilicio.nextflix.test_utils.mock
import io.github.mihmilicio.nextflix.test_utils.whenever
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class SerieRepositoryTest : SuiteDeTesteMockito, SuiteDeTesteDeClasse<SerieRepository> {

    private val serieRemoteDataSource: SerieRemoteDataSource = mock()

    override fun instanciar() = SerieRepository(serieRemoteDataSource)

    @Test
    fun listarSeriesPopulares() = runTest {
        val pagina = 1

        val listagemDeSeries = ListagemDeSeriesDto.stub
        whenever(serieRemoteDataSource.listarSeriesPopulares(pagina)).thenReturn(listagemDeSeries)

        val repository = instanciar()
        assertEquals(listagemDeSeries, repository.listarSeriesPopulares(pagina))
    }

    @Test
    fun buscarSeries() = runTest {
        val pagina = 1
        val busca = "flash"

        val listagemDeSeries = ListagemDeSeriesDto.stub
        whenever(serieRemoteDataSource.buscarSeries(pagina, busca)).thenReturn(listagemDeSeries)

        val repository = instanciar()
        assertEquals(listagemDeSeries, repository.buscarSeries(pagina, busca))
    }

    @Test
    fun consultarDetalhesDaSerie() = runTest {
        val id = 123L

        val detalheDaSerie = RespostaDetalheDaSerieDto.stub
        whenever(serieRemoteDataSource.consultarDetalhesDaSerie(id)).thenReturn(detalheDaSerie)

        val repository = instanciar()
        assertEquals(detalheDaSerie, repository.consultarDetalhesDaSerie(id))
    }
}