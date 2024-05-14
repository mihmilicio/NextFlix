package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.repository.WatchlistRepository
import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteDeClasse
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteMockito
import io.github.mihmilicio.nextflix.test_utils.mock
import io.github.mihmilicio.nextflix.test_utils.whenever
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.never
import org.mockito.Mockito.verify

class AdicionarSerieNaWatchlistUseCaseTest : SuiteDeTesteMockito,
    SuiteDeTesteDeClasse<AdicionarSerieNaWatchlistUseCase> {

    private val consultarDetalhesDaSerieUseCase: ConsultarDetalhesDaSerieUseCase = mock()
    private val watchlistRepository: WatchlistRepository = mock()

    override fun instanciar() =
        AdicionarSerieNaWatchlistUseCase(consultarDetalhesDaSerieUseCase, watchlistRepository)

    @Test
    fun `adicionar nova série na watchlist`() = runTest {
        val id = 123L
        val serie = DetalheDaSerie.stub

        whenever(watchlistRepository.buscarSerieNaWatchlist(id)).thenReturn(null)
        whenever(consultarDetalhesDaSerieUseCase(id)).thenReturn(serie)

        val adicionarSerieNaWatchlistUseCase = instanciar()
        adicionarSerieNaWatchlistUseCase(id)

        verify(watchlistRepository).adicionarSerieNaWatchlist(serie)
    }

    @Test
    fun `adicionar série existente na watchlist`() = runTest {
        val id = 123L
        val serie = DetalheDaSerie.stub

        whenever(watchlistRepository.buscarSerieNaWatchlist(id)).thenReturn(serie)

        val adicionarSerieNaWatchlistUseCase = instanciar()
        adicionarSerieNaWatchlistUseCase(id)

        verify(watchlistRepository, never()).adicionarSerieNaWatchlist(serie)
    }
}
