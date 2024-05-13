package io.github.mihmilicio.nextflix.data.repository

import io.github.mihmilicio.nextflix.data.datasource.SerieRemoteDataSource
import javax.inject.Inject

class SerieRepository @Inject constructor(
    private val serieRemoteDataSource: SerieRemoteDataSource
) {
    suspend fun listarSeriesPopulares(pagina: Int) =
        serieRemoteDataSource.listarSeriesPopulares(pagina)

    suspend fun buscarSeries(pagina: Int, busca: String) =
        serieRemoteDataSource.buscarSeries(pagina = pagina, busca = busca)

    suspend fun consultarDetalhesDaSerie(id: Long) =
        serieRemoteDataSource.consultarDetalhesDaSerie(id = id)
}