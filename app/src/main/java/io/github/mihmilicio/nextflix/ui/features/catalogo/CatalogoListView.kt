package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import io.github.mihmilicio.nextflix.domain.model.Serie
import io.github.mihmilicio.nextflix.ui.components.ErroRow
import io.github.mihmilicio.nextflix.ui.components.Loader
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme
import kotlinx.coroutines.flow.flowOf

@Composable
fun SerieGrid(seriePagingItems: LazyPagingItems<Serie>, onAdicionarSerie: (Serie) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(
            count = seriePagingItems.itemCount,
            key = seriePagingItems.itemKey { it.id }
        ) { i ->
            SerieCard(seriePagingItems[i]!!, onAdicionarSerie)
        }
        renderizarEstados(seriePagingItems)
    }
}

fun LazyGridScope.renderizarEstados(seriePagingItems: LazyPagingItems<Serie>) {
    seriePagingItems.apply {
        when {
            loadState.refresh is LoadState.Loading -> renderizarLoadingRow()

            loadState.refresh is LoadState.Error -> {
                val error = seriePagingItems.loadState.refresh as LoadState.Error
                renderizarErroRow(
                    loadStateError = error,
                    retry = { retry() }
                )
            }

            loadState.append is LoadState.Loading -> renderizarLoadingRow(
                modifier = Modifier.padding(
                    top = 12.dp
                )
            )


            loadState.append is LoadState.Error -> {
                val error = seriePagingItems.loadState.append as LoadState.Error
                renderizarErroRow(
                    loadStateError = error,
                    retry = { retry() },
                    modifier = Modifier.padding(top = 12.dp)
                )
            }
        }
    }
}

fun LazyGridScope.renderizarLoadingRow(modifier: Modifier = Modifier) {
    item(span = { GridItemSpan(maxLineSpan) }) {
        Loader(
            modifier = modifier
        )
    }
}

fun LazyGridScope.renderizarErroRow(
    loadStateError: LoadState.Error,
    retry: () -> Unit,
    modifier: Modifier = Modifier
) {
    item(span = { GridItemSpan(maxLineSpan) }) {
        ErroRow(
            modifier = modifier,
            mensagem = loadStateError.error.localizedMessage,
            onClickRetry = retry
        )
    }
}


@Preview
@Composable
fun SerieGridPreview() {
    NextFlixTheme {
        SerieGrid(
            flowOf(
                PagingData.from(
                    Serie.listaStub
                )
            ).collectAsLazyPagingItems(),
            onAdicionarSerie = {}
        )
    }
}
