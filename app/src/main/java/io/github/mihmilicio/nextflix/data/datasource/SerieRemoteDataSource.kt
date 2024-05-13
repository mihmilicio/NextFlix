package io.github.mihmilicio.nextflix.data.datasource

import io.github.mihmilicio.nextflix.data.dto.ListagemDeSeriesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SerieRemoteDataSource {

    @GET("most-popular")
    suspend fun listarSeriesPopulares(
        @Query("page") pagina: Int
    ): ListagemDeSeriesDto

    @GET("search")
    suspend fun buscarSeries(
        @Query("page") pagina: Int,
        @Query("q") busca: String
    ): ListagemDeSeriesDto

}