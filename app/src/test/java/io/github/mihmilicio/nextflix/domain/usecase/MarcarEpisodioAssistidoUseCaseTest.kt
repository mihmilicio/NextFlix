package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.repository.WatchlistRepository
import io.github.mihmilicio.nextflix.domain.model.Episodio
import io.github.mihmilicio.nextflix.domain.model.SerieParaAssistir
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteDeClasse
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteMockito
import io.github.mihmilicio.nextflix.test_utils.mock
import org.junit.Test
import org.mockito.Mockito.verify

class MarcarEpisodioAssistidoUseCaseTest : SuiteDeTesteMockito,
    SuiteDeTesteDeClasse<MarcarEpisodioAssistidoUseCase> {

    private val watchlistRepository: WatchlistRepository = mock()

    override fun instanciar() = MarcarEpisodioAssistidoUseCase(watchlistRepository)

    @Test
    fun invoke() {
        val serieAssistida = SerieParaAssistir(
            id = 35624,
            nome = "The Flash",
            posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg",
            foto = "https://static.episodate.com/images/episode/29560-242.jpg",
            episodio = Episodio(1, 1, "Pilot", false)
        )

        val episodioAssistido = Episodio(1, 1, "Pilot", true)


        val marcarEpisodioAssistidoUseCase = instanciar()
        marcarEpisodioAssistidoUseCase(serieAssistida)

        verify(watchlistRepository).atualizarEpisodioDaSerie(serieAssistida.id, episodioAssistido)
    }

}