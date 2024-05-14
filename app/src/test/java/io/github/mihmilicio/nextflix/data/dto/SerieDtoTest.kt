package io.github.mihmilicio.nextflix.data.dto

import io.github.mihmilicio.nextflix.domain.model.Serie
import org.junit.Assert.assertEquals
import org.junit.Test

class SerieDtoTest {
    @Test
    fun `transforma lista em model de serie`() {
        val seriesDto = listOf(
            SerieDto(
                id = 1,
                name = "Nome",
                image_thumbnail_path = "url"
            ),
            SerieDto(
                id = 2,
                name = "Flash",
                image_thumbnail_path = "url/poster"
            )
        )

        val modelDto = listOf(
            Serie(
                id = 1,
                nome = "Nome",
                posterUrl = "url"
            ),
            Serie(
                id = 2,
                nome = "Flash",
                posterUrl = "url/poster"
            )
        )

        assertEquals(modelDto, seriesDto.asDomainModel())
    }
}