package io.github.mihmilicio.nextflix.domain.catalogo

import io.github.mihmilicio.nextflix.data.Serie
import javax.inject.Inject

class ListarSeriesPopularesUseCase @Inject constructor() {

    operator fun invoke(): List<Serie> {
        return Serie.listaStub
    }
}