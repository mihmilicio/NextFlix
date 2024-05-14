package io.github.mihmilicio.nextflix.domain.model

data class DetalheDaSerie(
    val id: Long,
    val nome: String,
    val posterUrl: String,
    val foto: String?,
    var episodios: List<Episodio>,
    val assistida: Boolean = false
) {
    fun asSerie() = Serie(
        id = id,
        nome = nome,
        posterUrl = posterUrl
    )

    fun atualizarEpisodio(episodio: Episodio) {
        episodios = episodios
            .map {
                if (it.episodio == episodio.episodio && it.temporada == episodio.temporada) {
                    episodio
                } else {
                    it
                }
            }
    }

    companion object {
        val stub = DetalheDaSerie(
            id = 35624,
            nome = "The Flash",
            posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg",
            foto = "https://static.episodate.com/images/episode/29560-242.jpg",
            episodios = Episodio.listaStub
        )

        val listaStub = listOf(stub, stub, stub)
    }
}
