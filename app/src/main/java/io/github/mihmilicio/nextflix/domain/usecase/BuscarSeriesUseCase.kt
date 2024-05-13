package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.dto.ListagemDeSeriesDto
import io.github.mihmilicio.nextflix.data.repository.SerieRepository
import javax.inject.Inject

class BuscarSeriesUseCase @Inject constructor(
    private val serieRepository: SerieRepository
) {

    suspend operator fun invoke(pagina: Int, busca: String): ListagemDeSeriesDto =
        serieRepository.buscarSeries(pagina = pagina, busca = busca)

}