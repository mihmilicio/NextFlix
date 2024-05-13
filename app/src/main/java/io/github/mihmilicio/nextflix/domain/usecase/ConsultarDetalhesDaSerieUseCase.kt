package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.repository.SerieRepository
import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import javax.inject.Inject

class ConsultarDetalhesDaSerieUseCase @Inject constructor(
    private val serieRepository: SerieRepository
) {

    suspend operator fun invoke(id: Long): DetalheDaSerie =
        serieRepository.consultarDetalhesDaSerie(id = id).asDomainModel()

}