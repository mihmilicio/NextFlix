package io.github.mihmilicio.nextflix.data.dto

import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import io.github.mihmilicio.nextflix.domain.model.Episodio
import org.junit.Assert.assertEquals
import org.junit.Test

class DetalheDaSerieDtoTest {

    @Test
    fun `transforma em detalhe da série`() {
        val dto = DetalheDaSerieDto(
            id = 123L,
            name = "Nome",
            image_thumbnail_path = "url",
            pictures = listOf("url.foto"),
            episodes = listOf(EpisodioDto(1, 1, "Episodio 1"))
        )

        val model = DetalheDaSerie(
            id = 123L,
            nome = "Nome",
            posterUrl = "url",
            foto = "url.foto",
            episodios = listOf(Episodio(1, 1, "Episodio 1"))
        )

        assertEquals(model, dto.asDomainModel())
    }
}