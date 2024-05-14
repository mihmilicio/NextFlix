package io.github.mihmilicio.nextflix.ui.features.watchlist

import io.github.mihmilicio.nextflix.domain.model.Episodio
import io.github.mihmilicio.nextflix.domain.model.SerieParaAssistir
import io.github.mihmilicio.nextflix.domain.usecase.ListarSeriesParaAssistirUseCase
import io.github.mihmilicio.nextflix.domain.usecase.MarcarEpisodioAssistidoUseCase
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteMockito
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteViewModel
import io.github.mihmilicio.nextflix.test_utils.mock
import io.github.mihmilicio.nextflix.test_utils.whenever
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class WatchlistViewModelTest : SuiteDeTesteViewModel<WatchlistViewModel>, SuiteDeTesteMockito {

    private val listarSeriesParaAssistirUseCase: ListarSeriesParaAssistirUseCase = mock()
    private val marcarEpisodioAssistidoUseCase: MarcarEpisodioAssistidoUseCase = mock()

    override fun instanciarViewModel() =
        WatchlistViewModel(listarSeriesParaAssistirUseCase, marcarEpisodioAssistidoUseCase)


    @Test
    fun `deve listar series para assistir`() {
        val seriesEsperadas = SerieParaAssistir.listaStub
        whenever(listarSeriesParaAssistirUseCase()).thenReturn(seriesEsperadas)

        val viewModel = instanciarViewModel()

        verify(listarSeriesParaAssistirUseCase).invoke()
        assertEquals(seriesEsperadas, viewModel.series)
    }

    @Test
    fun `deve mostrar o próximo episódio para assistir`() {
        val seriesIniciais = SerieParaAssistir.listaStub
        val serieAssistida = seriesIniciais[1]

        val serieAssistidaProximoEpisodio =
            SerieParaAssistir.stub2.copy(episodio = Episodio(1, 2, "The Kingsroad", false))

        val seriesAtualizadas = listOf(
            SerieParaAssistir.stub,
            serieAssistidaProximoEpisodio,
            SerieParaAssistir.stub3,
        )
        whenever(listarSeriesParaAssistirUseCase()).thenReturn(seriesIniciais, seriesAtualizadas)

        val viewModel = instanciarViewModel()
        viewModel.marcarEpisodioAssistido(serieAssistida)

        verify(marcarEpisodioAssistidoUseCase).invoke(serieAssistida)
        verify(listarSeriesParaAssistirUseCase, times(2)).invoke()

        val seriesOrdenadas = listOf(
            serieAssistidaProximoEpisodio,
            SerieParaAssistir.stub,
            SerieParaAssistir.stub3,
        )
        assertEquals(seriesOrdenadas, viewModel.series.toList())
    }

    @Test
    fun `deve remover série finalizada`() {
        val seriesIniciais = SerieParaAssistir.listaStub
        val serieAssistida = seriesIniciais[1]

        val seriesAtualizadas = listOf(
            SerieParaAssistir.stub,
            SerieParaAssistir.stub3,
        )
        whenever(listarSeriesParaAssistirUseCase()).thenReturn(seriesIniciais, seriesAtualizadas)

        val viewModel = instanciarViewModel()
        viewModel.marcarEpisodioAssistido(serieAssistida)

        verify(marcarEpisodioAssistidoUseCase).invoke(serieAssistida)
        verify(listarSeriesParaAssistirUseCase, times(2)).invoke()

        val seriesOrdenadas = listOf(
            SerieParaAssistir.stub,
            SerieParaAssistir.stub3,
        )
        assertEquals(seriesOrdenadas, viewModel.series.toList())
    }


}