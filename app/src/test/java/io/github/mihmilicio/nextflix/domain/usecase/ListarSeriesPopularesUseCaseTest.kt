package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.dto.ListagemDeSeriesDto
import io.github.mihmilicio.nextflix.data.repository.SerieRepository
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteDeClasse
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteMockito
import io.github.mihmilicio.nextflix.test_utils.mock
import io.github.mihmilicio.nextflix.test_utils.whenever
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ListarSeriesPopularesUseCaseTest : SuiteDeTesteMockito,
    SuiteDeTesteDeClasse<ListarSeriesPopularesUseCase> {

    private val serieRepository: SerieRepository = mock()

    override fun instanciar() = ListarSeriesPopularesUseCase(serieRepository)

    @Test
    fun invoke() = runTest {
        val pagina = 1

        val listagemDeSeries = ListagemDeSeriesDto.stub
        whenever(serieRepository.listarSeriesPopulares(pagina)).thenReturn(listagemDeSeries)

        val listarSeriesPopularesUseCase = instanciar()
        val series = listarSeriesPopularesUseCase(pagina)

        assertEquals(listagemDeSeries, series)
    }


}