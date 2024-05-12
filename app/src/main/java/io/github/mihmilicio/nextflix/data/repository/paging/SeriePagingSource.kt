package io.github.mihmilicio.nextflix.data.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.github.mihmilicio.nextflix.data.Serie
import io.github.mihmilicio.nextflix.data.datasource.SerieRemoteDataSource
import io.github.mihmilicio.nextflix.data.dto.asDomainModel
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SeriePagingSource @Inject constructor(
    private val serieRemoteDataSource: SerieRemoteDataSource,
) : PagingSource<Int, Serie>() {

    companion object {
        const val PAGE_SIZE = 20
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Serie> {
        return try {
            val currentPage = params.key ?: 1
            val resposta = serieRemoteDataSource.consultarSeries(
                pagina = currentPage
            )
            LoadResult.Page(
                data = resposta.tv_shows.asDomainModel(),
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (resposta.tv_shows.isEmpty()) null else resposta.page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Serie>): Int? {
        return state.anchorPosition
    }

}