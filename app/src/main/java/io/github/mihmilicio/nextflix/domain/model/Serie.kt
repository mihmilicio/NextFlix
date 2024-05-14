package io.github.mihmilicio.nextflix.domain.model

data class Serie(
    val id: Long,
    val nome: String,
    val posterUrl: String
) {

    companion object {
        val stub = Serie(
            id = 35624,
            nome = "The Flash",
            posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg"
        )

        val listaStub = listOf(
            Serie(
                id = 35624,
                nome = "The Flash",
                posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg"
            ),
            Serie(
                id = 23455,
                nome = "Game of Thrones",
                posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/23455.jpg",
            ),
            Serie(
                id = 29560,
                nome = "Arrow",
                posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/29560.jpg",
            ),
            Serie(
                id = 23455,
                nome = "Game of Thrones",
                posterUrl = "",
            ),
            Serie(
                id = 29560,
                nome = "Arrow",
                posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/29560.jpg",
            ),
        )
    }
}
