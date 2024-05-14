package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.dto.ListagemDeSeriesDto
import io.github.mihmilicio.nextflix.data.dto.SerieDto
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteDeClasse
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteMockito
import io.github.mihmilicio.nextflix.test_utils.mock
import io.github.mihmilicio.nextflix.test_utils.whenever
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class DirecionarConsultaDoCatalogoUseCaseTest : SuiteDeTesteMockito,
    SuiteDeTesteDeClasse<DirecionarConsultaDoCatalogoUseCase> {

    private val listarSeriesPopularesUseCase: ListarSeriesPopularesUseCase = mock()
    private val buscarSeriesUseCase: BuscarSeriesUseCase = mock()

    override fun instanciar() =
        DirecionarConsultaDoCatalogoUseCase(listarSeriesPopularesUseCase, buscarSeriesUseCase)

    @Test
    fun invoke() = runTest {
        val pagina = 1
        val busca = "  a"

        val todasAsSeries = ListagemDeSeriesDto.stub
        whenever(listarSeriesPopularesUseCase(pagina)).thenReturn(todasAsSeries)

        val seriesBuscadas = ListagemDeSeriesDto.stub.copy(tv_shows = listOf(SerieDto.stub))
        whenever(buscarSeriesUseCase(pagina, busca)).thenReturn(seriesBuscadas)

        val direcionarConsultaDoCatalogoUseCase = instanciar()

        assertEquals(todasAsSeries, direcionarConsultaDoCatalogoUseCase(pagina, ""))

        assertEquals(todasAsSeries, direcionarConsultaDoCatalogoUseCase(pagina, "  "))

        assertEquals(seriesBuscadas, direcionarConsultaDoCatalogoUseCase(pagina, busca))
    }
}
