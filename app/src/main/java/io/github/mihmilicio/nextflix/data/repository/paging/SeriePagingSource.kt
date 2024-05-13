package io.github.mihmilicio.nextflix.data.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.github.mihmilicio.nextflix.data.Serie
import io.github.mihmilicio.nextflix.data.dto.asDomainModel
import io.github.mihmilicio.nextflix.domain.catalogo.DirecionarConsultaDoCatalogoUseCase
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SeriePagingSource @Inject constructor(
    private val direcionarConsultaDoCatalogoUseCase: DirecionarConsultaDoCatalogoUseCase,
    var busca: String
) : PagingSource<Int, Serie>() {

    companion object {
        const val TAMANHO_DA_PAGINA = 20
        const val PREFETCH_DISTANCE = 3
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Serie> {
        return try {
            val paginaAtual = params.key ?: 1
            val resposta = direcionarConsultaDoCatalogoUseCase(pagina = paginaAtual, busca = busca)

            LoadResult.Page(
                data = resposta.tv_shows.asDomainModel(),
                prevKey = if (paginaAtual == 1) null else paginaAtual - 1,
                nextKey = if (resposta.page >= resposta.pages) null else resposta.page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Serie>): Int = 1

}