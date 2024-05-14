package io.github.mihmilicio.nextflix.domain.usecase

import androidx.paging.PagingSource
import io.github.mihmilicio.nextflix.domain.model.Serie
import io.github.mihmilicio.nextflix.domain.usecase.paging.SeriePagingSource
import javax.inject.Inject

class InicializarPaginacaoDoCatalogoUseCase @Inject constructor(
    private val direcionarConsultaDoCatalogoUseCase: DirecionarConsultaDoCatalogoUseCase
) {

    operator fun invoke(busca: String): () -> PagingSource<Int, Serie> = {
        SeriePagingSource(direcionarConsultaDoCatalogoUseCase, busca)
    }
}