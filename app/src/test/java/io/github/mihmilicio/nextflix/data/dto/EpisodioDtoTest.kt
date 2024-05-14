package io.github.mihmilicio.nextflix.data.dto

import io.github.mihmilicio.nextflix.domain.model.Episodio
import org.junit.Assert.assertEquals
import org.junit.Test

class EpisodioDtoTest {
    @Test
    fun `transforma lista em model de episodio`() {
        val episodios = listOf(EpisodioDto(1, 1, "Episodio 1"), EpisodioDto(1, 2, "Episodio 2"))

        val model = listOf(Episodio(1, 1, "Episodio 1"), Episodio(1, 2, "Episodio 2"))

        assertEquals(model, episodios.asDomainModel())
    }
}