package io.github.mihmilicio.nextflix.domain.model

data class Episodio(
    val temporada: Int,
    val episodio: Int,
    val nome: String,
    val assistido: Boolean = false
) {
    companion object {
        val stub = Episodio(
            temporada = 1,
            episodio = 1,
            nome = "Piloto"
        )

        val listaStub = listOf(
            Episodio(
                temporada = 1,
                episodio = 1,
                nome = "Piloto"
            ),
            Episodio(
                temporada = 1,
                episodio = 2,
                nome = "O Poderoso Chefão"
            ),
            Episodio(
                temporada = 1,
                episodio = 3,
                nome = "Um Estranho no Ninho"
            ),
            Episodio(
                temporada = 2,
                episodio = 1,
                nome = "Um Estranho no Ninho 2 "
            ),
            Episodio(
                temporada = 2,
                episodio = 2,
                nome = "Um Estranho no Ninho 3"
            )
        )
    }
}
