package io.github.mihmilicio.nextflix.domain.model

data class SerieParaAssistir(
    val id: Long,
    val nome: String,
    val posterUrl: String,
    val foto: String?,
    var episodio: Episodio
) {
    companion object {
        val stub = SerieParaAssistir(
            id = 35624,
            nome = "The Flash",
            posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg",
            foto = "https://static.episodate.com/images/episode/29560-242.jpg",
            episodio = Episodio(1, 1, "Pilot", false)
        )

        val stub2 = SerieParaAssistir(
            id = 23455,
            nome = "Game of Thrones",
            posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/23455.jpg",
            foto = null,
            episodio = Episodio(1, 1, "Winter is Coming", false)
        )

        val stub3 = SerieParaAssistir(
            id = 29560,
            nome = "Arrow",
            posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/29560.jpg",
            foto = null,
            episodio = Episodio(1, 1, "Pilot", false)
        )

        val listaStub = listOf(stub, stub2, stub3)
    }
}