package io.github.mihmilicio.nextflix.domain.catalogo

import io.github.mihmilicio.nextflix.data.Serie
import io.github.mihmilicio.nextflix.data.dto.asDomainModel
import io.github.mihmilicio.nextflix.data.repository.SerieRepository
import javax.inject.Inject

class ListarSeriesPopularesUseCase @Inject constructor(
    private val serieRepository: SerieRepository
) {

    suspend operator fun invoke(): List<Serie> {
        return serieRepository.consultarSeries().tv_shows.asDomainModel()
    }
}