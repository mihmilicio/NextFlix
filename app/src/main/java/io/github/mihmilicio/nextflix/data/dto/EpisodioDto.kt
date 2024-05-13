package io.github.mihmilicio.nextflix.data.dto

import io.github.mihmilicio.nextflix.domain.model.Episodio
import kotlinx.serialization.Serializable

@Serializable
data class EpisodioDto(
    val season: Int,
    val episode: Int,
    val name: String,
)

fun List<EpisodioDto>.asDomainModel() = map {
    Episodio(
        temporada = it.season,
        episodio = it.episode,
        nome = it.name
    )
}
