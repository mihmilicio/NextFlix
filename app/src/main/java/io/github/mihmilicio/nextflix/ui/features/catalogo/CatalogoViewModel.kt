package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mihmilicio.nextflix.domain.model.Serie
import io.github.mihmilicio.nextflix.domain.usecase.DirecionarConsultaDoCatalogoUseCase
import io.github.mihmilicio.nextflix.domain.usecase.paging.SeriePagingSource
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class CatalogoViewModel @Inject constructor(
    private val direcionarConsultaDoCatalogoUseCase: DirecionarConsultaDoCatalogoUseCase

) : ViewModel() {

    private val queryParaBuscar = MutableStateFlow("")
    private val _queryComDebounce = MutableStateFlow("")

    var textoCampoDeBusca by mutableStateOf("")
        private set

    private var pagingSource = inicializarPagingSource(_queryComDebounce.value)

    private val pager: Pager<Int, Serie> = Pager(
        config = PagingConfig(
            pageSize = SeriePagingSource.TAMANHO_DA_PAGINA,
            prefetchDistance = SeriePagingSource.PREFETCH_DISTANCE
        ),
        pagingSourceFactory = { inicializarPagingSource(_queryComDebounce.value) }
    )
    var seriesPaging = pager.flow

    init {
        queryParaBuscar
            .debounce(BUSCA_DEBOUNCE_MS)
            .distinctUntilChanged()
            .onEach {
                _queryComDebounce.value = it
                atualizarPager()
            }
            .launchIn(viewModelScope)
    }

    private fun inicializarPagingSource(busca: String): PagingSource<Int, Serie> {
        pagingSource = SeriePagingSource(direcionarConsultaDoCatalogoUseCase, busca)
        return pagingSource
    }

    private fun atualizarPager() {
        pagingSource.invalidate()
    }

    fun atualizarTextoDeBusca(input: String) {
        textoCampoDeBusca = input
        atualizarQueryDeBusca(input)
    }

    fun atualizarQueryDeBusca(query: String) {
        if (queryParaBuscar.value.isEmpty() && query.isBlank()) return
        if (queryParaBuscar.value.isBlank() && query.length < BUSCA_MINIMO_CARACTERES) return

        queryParaBuscar.tryEmit(query)
    }

    companion object {
        private const val BUSCA_DEBOUNCE_MS = 300L
        private const val BUSCA_MINIMO_CARACTERES = 3
    }
}