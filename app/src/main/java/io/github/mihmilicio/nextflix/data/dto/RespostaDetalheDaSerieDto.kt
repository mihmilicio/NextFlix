package io.github.mihmilicio.nextflix.data.dto

import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import kotlinx.serialization.Serializable

@Serializable
data class RespostaDetalheDaSerieDto(
    val tvShow: DetalheDaSerieDto
) {
    fun asDomainModel(): DetalheDaSerie = tvShow.asDomainModel()
}
