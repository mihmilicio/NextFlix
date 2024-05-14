package io.github.mihmilicio.nextflix.domain.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DetalheDaSerieTest {

    @Test
    fun `verifica se tem episodios nao assistidos`() {
        val detalheDaSerie = DetalheDaSerie.stub.copy()

        detalheDaSerie.episodios = Episodio.listaStub
        assertTrue(detalheDaSerie.temEpisodiosNaoAssistidos())

        detalheDaSerie.episodios = Episodio.stubTodosAssistidos
        assertFalse(detalheDaSerie.temEpisodiosNaoAssistidos())

        detalheDaSerie.episodios = Episodio.stubApenasUmNaoAssistido
        assertTrue(detalheDaSerie.temEpisodiosNaoAssistidos())
    }

    @Test
    fun `transforma em serie da watchlist`() {
        val episodioNaoAssistido = Episodio(
            temporada = 1, episodio = 2, nome = "O Poderoso Chefão", assistido = false
        )

        val detalheDaSerie = DetalheDaSerie(
            id = 123L, nome = "Nome", posterUrl = "url", foto = "url.foto", episodios = listOf(
                Episodio(
                    temporada = 1, episodio = 1, nome = "Episodio 1", assistido = true
                ), episodioNaoAssistido
            )
        )

        val serieParaAssistir = SerieParaAssistir(
            id = 123L,
            nome = "Nome",
            posterUrl = "url",
            foto = "url.foto",
            episodio = episodioNaoAssistido
        )

        assertEquals(serieParaAssistir, detalheDaSerie.asSerieParaAssistir())
    }


    @Test
    fun `atualiza episodio especifico`() {
        val detalheDaSerie = DetalheDaSerie.stub.copy()

        val ep1temp1 = Episodio(
            temporada = 1, episodio = 1, nome = "Piloto"
        )
        val ep2temp1 = Episodio(
            temporada = 1, episodio = 2, nome = "O Poderoso Chefão"
        )
        val ep1temp2 = Episodio(
            temporada = 2, episodio = 1, nome = "Um Estranho no Ninho 2 "
        )
        val ep2temp2 = Episodio(
            temporada = 2, episodio = 2, nome = "Um Estranho no Ninho 3"
        )
        val episodiosOriginal = listOf(ep1temp1, ep2temp1, ep1temp2, ep2temp2)
        detalheDaSerie.episodios = episodiosOriginal

        val ep1temp2Atualizado = Episodio(
            temporada = 2, episodio = 1, nome = "Um Estranho no Ninho 2", assistido = true
        )
        detalheDaSerie.atualizarEpisodio(ep1temp2Atualizado)

        val episodiosEsperado = listOf(ep1temp1, ep2temp1, ep1temp2Atualizado, ep2temp2)
        assertEquals(episodiosEsperado, detalheDaSerie.episodios)

        assertFalse(detalheDaSerie.assistida)
    }

    @Test
    fun `todos os episodios assistidos`() {
        val detalheDaSerie = DetalheDaSerie.stub.copy()

        detalheDaSerie.atualizarEpisodio(detalheDaSerie.episodios[0].copy(assistido = true))
        assertTrue(detalheDaSerie.assistida)
    }


}