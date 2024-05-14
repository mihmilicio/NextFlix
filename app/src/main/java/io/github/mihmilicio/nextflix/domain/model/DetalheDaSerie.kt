package io.github.mihmilicio.nextflix.domain.model

data class DetalheDaSerie(
    val id: Long,
    val nome: String,
    val posterUrl: String,
    val foto: String?,
    var episodios: List<Episodio>,
    var assistida: Boolean = false
) {
    fun temEpisodiosNaoAssistidos() = episodios.any { !it.assistido }

    fun asSerieParaAssistir() = SerieParaAssistir(
        id = id,
        nome = nome,
        posterUrl = posterUrl,
        foto = foto,
        episodio = episodios.first { !it.assistido }
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

        assistida = episodios.all { it.assistido }
    }

    companion object {
        val stub = DetalheDaSerie(
            id = 1234L,
            nome = "Nome",
            posterUrl = "url",
            foto = "url.foto",
            episodios = listOf(
                Episodio(
                    temporada = 1,
                    episodio = 1,
                    nome = "Episodio 1"
                )
            )
        )

        val stubAssistida = DetalheDaSerie(
            id = 9874L,
            nome = "Nome",
            posterUrl = "url",
            foto = "url.foto",
            assistida = true,
            episodios = listOf(
                Episodio(
                    temporada = 1,
                    episodio = 1,
                    nome = "Episodio 1",
                    assistido = true
                )
            )
        )
    }
}
