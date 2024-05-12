package io.github.mihmilicio.nextflix.data.dto

import io.github.mihmilicio.nextflix.data.Serie
import kotlinx.serialization.Serializable

@Serializable
data class SerieDto(
    val id: Long,
    val name: String,
    val image_thumbnail_path: String
)

fun List<SerieDto>.asDomainModel() = map {
    Serie(
        id = it.id,
        nome = it.name,
        posterUrl = it.image_thumbnail_path
    )
}