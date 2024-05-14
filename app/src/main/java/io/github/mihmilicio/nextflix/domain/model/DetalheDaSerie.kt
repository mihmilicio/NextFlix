package io.github.mihmilicio.nextflix.domain.model

data class DetalheDaSerie(
    val id: Long,
    val nome: String,
    val posterUrl: String,
    val foto: String?,
    var episodios: List<Episodio>,
    val assistida: Boolean = false
) {
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
    }
}
