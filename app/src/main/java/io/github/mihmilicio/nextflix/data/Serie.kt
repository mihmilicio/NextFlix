package io.github.mihmilicio.nextflix.data

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
                id = 35624,
                nome = "The Flash texto muito longo nesse aqui pra ver como fica",
                posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg"
            ),
            Serie(
                id = 35624,
                nome = "The Flash",
                posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg"
            ),
            Serie(
                id = 35624,
                nome = "The Flash",
                posterUrl = ""
            ),
            Serie(
                id = 35624,
                nome = "The Flash",
                posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg"
            )
        )
    }
}
