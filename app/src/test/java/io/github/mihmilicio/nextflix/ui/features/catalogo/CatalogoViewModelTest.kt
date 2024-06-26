package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.paging.testing.asPagingSourceFactory
import androidx.paging.testing.asSnapshot
import io.github.mihmilicio.nextflix.domain.model.Serie
import io.github.mihmilicio.nextflix.domain.usecase.AdicionarSerieNaWatchlistUseCase
import io.github.mihmilicio.nextflix.domain.usecase.InicializarPaginacaoDoCatalogoUseCase
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteCoroutines
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteDeClasse
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteMockito
import io.github.mihmilicio.nextflix.test_utils.mock
import io.github.mihmilicio.nextflix.test_utils.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.verify

@OptIn(ExperimentalCoroutinesApi::class)
class CatalogoViewModelTest : SuiteDeTesteDeClasse<CatalogoViewModel>, SuiteDeTesteMockito,
    SuiteDeTesteCoroutines() {

    private val inicializarPaginacaoDoCatalogoUseCase: InicializarPaginacaoDoCatalogoUseCase =
        mock()
    private val adicionarSerieNaWatchlistUseCase: AdicionarSerieNaWatchlistUseCase = mock()

    override fun instanciar() =
        CatalogoViewModel(inicializarPaginacaoDoCatalogoUseCase, adicionarSerieNaWatchlistUseCase)

    @Test
    fun `deve listar series disponiveis`() = runTest {
        val busca = ""
        val seriesEsperadas = Serie.listaStub
        whenever(inicializarPaginacaoDoCatalogoUseCase(busca)).thenReturn { seriesEsperadas.asPagingSourceFactory()() }


        val viewModel = instanciar()

        verify(inicializarPaginacaoDoCatalogoUseCase).invoke(busca)
        assertEquals(seriesEsperadas, viewModel.seriesPaging.asSnapshot { })
    }

    @Test
    fun `deve listar series buscadas`() = runTest {
        val buscaPadrao = ""
        val busca = "Flash"

        val todasAsSeries = Serie.listaStub
        val seriesFiltradas = listOf(Serie.stub)

        whenever(inicializarPaginacaoDoCatalogoUseCase(busca = buscaPadrao)).thenReturn { todasAsSeries.asPagingSourceFactory()() }
        whenever(inicializarPaginacaoDoCatalogoUseCase(busca = busca)).thenReturn { seriesFiltradas.asPagingSourceFactory()() }

        val viewModel = instanciar()

        assertEquals(todasAsSeries, viewModel.seriesPaging.asSnapshot { })

        viewModel.atualizarTextoDeBusca(busca)

        advanceUntilIdle()

        assertEquals(seriesFiltradas, viewModel.seriesPaging.asSnapshot { })
    }

    @Test
    fun `nao deve buscar valores invalidos`() = runTest {
        val buscaPadrao = ""

        val todasAsSeries = Serie.listaStub
        val seriesFiltradas = listOf(Serie.stub)

        whenever(inicializarPaginacaoDoCatalogoUseCase(busca = buscaPadrao)).thenReturn { todasAsSeries.asPagingSourceFactory()() }
        whenever(inicializarPaginacaoDoCatalogoUseCase(busca = "arr")).thenReturn { seriesFiltradas.asPagingSourceFactory()() }

        val viewModel = instanciar()

        assertEquals(todasAsSeries, viewModel.seriesPaging.asSnapshot { })

        var busca = "   "
        viewModel.atualizarTextoDeBusca(busca)
        advanceUntilIdle()
        assertEquals(todasAsSeries, viewModel.seriesPaging.asSnapshot { })

        busca = "a"
        viewModel.atualizarTextoDeBusca(busca)
        advanceUntilIdle()
        assertEquals(todasAsSeries, viewModel.seriesPaging.asSnapshot { })


        busca = "arr"
        viewModel.atualizarTextoDeBusca(busca)
        advanceUntilIdle()
        assertEquals(seriesFiltradas, viewModel.seriesPaging.asSnapshot { })

        busca = ""
        viewModel.atualizarTextoDeBusca(busca)
        advanceUntilIdle()
        assertEquals(todasAsSeries, viewModel.seriesPaging.asSnapshot { })
    }


    @Test
    fun `adicionar serie na watchlist`() = runTest {
        val seriesEsperadas = Serie.listaStub
        whenever(inicializarPaginacaoDoCatalogoUseCase("")).thenReturn { seriesEsperadas.asPagingSourceFactory()() }

        val viewModel = instanciar()

        val serieParaAdicionar = Serie.stub
        viewModel.adicionarSerie(serieParaAdicionar)
        advanceUntilIdle()

        verify(adicionarSerieNaWatchlistUseCase).invoke(serieParaAdicionar.id)
        // TODO feedback
    }
}
