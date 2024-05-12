package io.github.mihmilicio.nextflix.data.datasource

import io.github.mihmilicio.nextflix.data.dto.ListagemDeSeriesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SerieRemoteDataSource {

    @GET("most-popular")
    suspend fun consultarSeries(
        @Query("page") pagina: Int
    ): ListagemDeSeriesDto

}