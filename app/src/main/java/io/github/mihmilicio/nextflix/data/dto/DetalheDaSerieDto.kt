package io.github.mihmilicio.nextflix.data.dto

import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import kotlinx.serialization.Serializable

@Serializable
data class DetalheDaSerieDto(
    val id: Long,
    val name: String,
    val image_thumbnail_path: String,
    val pictures: List<String>,
    val episodes: List<EpisodioDto>
) {
    fun asDomainModel() = DetalheDaSerie(
        id = id,
        nome = name,
        posterUrl = image_thumbnail_path,
        foto = pictures.elementAtOrNull(0),
        episodios = episodes.asDomainModel()
    )
}
