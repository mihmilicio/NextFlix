package io.github.mihmilicio.nextflix.domain.catalogo

import androidx.paging.PagingData
import io.github.mihmilicio.nextflix.data.Serie
import io.github.mihmilicio.nextflix.data.repository.SerieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListarSeriesPopularesUseCase @Inject constructor(
    private val serieRepository: SerieRepository
) {

    operator fun invoke(): Flow<PagingData<Serie>> =
        serieRepository.consultarSeries()

}