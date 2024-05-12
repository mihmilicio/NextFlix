package io.github.mihmilicio.nextflix.data.repository

import io.github.mihmilicio.nextflix.data.datasource.SerieRemoteDataSource
import javax.inject.Inject

class SerieRepository @Inject constructor(
    private val serieRemoteDataSource: SerieRemoteDataSource
) {
    suspend fun consultarSeries() = serieRemoteDataSource.consultarSeries(1)

}