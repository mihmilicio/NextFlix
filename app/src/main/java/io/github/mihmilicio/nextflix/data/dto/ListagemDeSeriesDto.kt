package io.github.mihmilicio.nextflix.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ListagemDeSeriesDto(
    val total: String,
    val page: Int,
    val pages: Int,
    val tv_shows: List<SerieDto>
) {

    companion object {
        val stub = ListagemDeSeriesDto(
            total = "1",
            page = 1,
            pages = 1,
            tv_shows = listOf(SerieDto.stub, SerieDto.stub)
        )
    }
}
