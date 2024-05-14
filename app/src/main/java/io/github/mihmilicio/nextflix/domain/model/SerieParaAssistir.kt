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
            episodio = Episodio.stub
        )

        val listaStub = listOf(stub, stub, stub)
    }
}