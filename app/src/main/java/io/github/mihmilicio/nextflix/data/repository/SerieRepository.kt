package io.github.mihmilicio.nextflix.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import io.github.mihmilicio.nextflix.data.Serie
import io.github.mihmilicio.nextflix.data.datasource.SerieRemoteDataSource
import io.github.mihmilicio.nextflix.data.repository.paging.SeriePagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SerieRepository @Inject constructor(
    private val serieRemoteDataSource: SerieRemoteDataSource
) {
    fun consultarSeries(): Flow<PagingData<Serie>> = Pager(
        config = PagingConfig(pageSize = SeriePagingSource.PAGE_SIZE, prefetchDistance = 2),
        pagingSourceFactory = {
            SeriePagingSource(serieRemoteDataSource)
        }
    ).flow


}