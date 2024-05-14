package io.github.mihmilicio.nextflix.domain.model

data class EpisodioDaWatchlist(
    val temporada: Int,
    val episodio: Int,
    val nome: String,
    val serie: Serie,
    val foto: String?
) {

    fun asEpisodio() = Episodio(
        temporada = temporada,
        episodio = episodio,
        nome = nome
    )

    companion object {
        val stub = EpisodioDaWatchlist(
            temporada = 1,
            episodio = 1,
            nome = "Piloto",
            serie = Serie.stub,
            foto = "https://static.episodate.com/images/episode/29560-242.jpg"
        )

        val listaStub = listOf(stub, stub, stub)
    }
}
