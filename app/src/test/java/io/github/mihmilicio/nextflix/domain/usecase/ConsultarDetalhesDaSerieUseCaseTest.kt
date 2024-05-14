package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.dto.DetalheDaSerieDto
import io.github.mihmilicio.nextflix.data.dto.EpisodioDto
import io.github.mihmilicio.nextflix.data.dto.RespostaDetalheDaSerieDto
import io.github.mihmilicio.nextflix.data.repository.SerieRepository
import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import io.github.mihmilicio.nextflix.domain.model.Episodio
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteDeClasse
import io.github.mihmilicio.nextflix.test_utils.SuiteDeTesteMockito
import io.github.mihmilicio.nextflix.test_utils.mock
import io.github.mihmilicio.nextflix.test_utils.whenever
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ConsultarDetalhesDaSerieUseCaseTest : SuiteDeTesteMockito,
    SuiteDeTesteDeClasse<ConsultarDetalhesDaSerieUseCase> {

    private val serieRepository: SerieRepository = mock()

    override fun instanciar() = ConsultarDetalhesDaSerieUseCase(serieRepository)

    @Test
    fun invoke() = runTest {
        val id = 12345L

        val respostaDetalheDaSerie = RespostaDetalheDaSerieDto(
            tvShow = DetalheDaSerieDto(
                id = id,
                name = "Nome",
                image_thumbnail_path = "url",
                pictures = listOf("url.foto"),
                episodes = listOf(
                    EpisodioDto(
                        season = 1,
                        episode = 1,
                        name = "Episodio 1"
                    )
                )
            )
        )
        whenever(serieRepository.consultarDetalhesDaSerie(id)).thenReturn(respostaDetalheDaSerie)

        val detalheDaSerieModel = DetalheDaSerie(
            id = id,
            nome = "Nome",
            posterUrl = "url",
            foto = "url.foto",
            episodios = listOf(
                Episodio(
                    temporada = 1,
                    episodio = 1,
                    nome = "Episodio 1"
                )
            )
        )

        val listarSeriesPopularesUseCase = instanciar()
        val series = listarSeriesPopularesUseCase(id)

        assertEquals(detalheDaSerieModel, series)
    }
}
