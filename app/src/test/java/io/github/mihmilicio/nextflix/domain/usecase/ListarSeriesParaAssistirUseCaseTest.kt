package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.repository.WatchlistRepository
import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import io.github.mihmilicio.nextflix.domain.model.Episodio
import io.github.mihmilicio.nextflix.domain.model.SerieParaAssistir
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteDeClasse
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteMockito
import io.github.mihmilicio.nextflix.test_utils.mock
import io.github.mihmilicio.nextflix.test_utils.whenever
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ListarSeriesParaAssistirUseCaseTest : SuiteDeTesteMockito,
    SuiteDeTesteDeClasse<ListarSeriesParaAssistirUseCase> {

    private val watchlistRepository: WatchlistRepository = mock()

    override fun instanciar() = ListarSeriesParaAssistirUseCase(watchlistRepository)

    @Test
    fun invoke() = runTest {
        val seriesNaWatchlist = listOf(
            DetalheDaSerie(
                id = 123L,
                nome = "Nome",
                posterUrl = "url",
                foto = "url.foto",
                episodios = listOf(
                    Episodio.stub
                )
            )
        )

        val seriesParaAssistir = listOf(
            SerieParaAssistir(
                id = 123L,
                nome = "Nome",
                posterUrl = "url",
                foto = "url.foto",
                episodio = Episodio.stub
            )
        )

        whenever(watchlistRepository.listarSeriesNaWatchlist()).thenReturn(seriesNaWatchlist)

        val listarSeriesParaAssistirUseCase = instanciar()
        assertEquals(seriesParaAssistir, listarSeriesParaAssistirUseCase())
    }
}
