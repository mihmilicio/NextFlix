package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import io.github.mihmilicio.nextflix.data.Serie
import io.github.mihmilicio.nextflix.ui.components.Loader
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme
import kotlinx.coroutines.flow.flowOf

@Composable
fun SerieGrid(seriePagingItems: LazyPagingItems<Serie>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(seriePagingItems.itemCount) { i ->
            SerieCard(seriePagingItems[i]!!)
        }
        renderizarEstados(seriePagingItems.loadState)
    }
}

fun LazyGridScope.renderizarEstados(loadState: CombinedLoadStates) {
    loadState.apply {
        when {
            refresh is LoadState.Loading -> {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    Loader(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            refresh is LoadState.Error -> {
                // TODO
            }

            append is LoadState.Loading -> {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    Loader(
                        modifier = Modifier.padding(top = 12.dp)
                    )

                }
            }

            append is LoadState.Error -> {
                // TODO
            }
        }
    }
}

@Preview
@Composable
fun SerieGridPreview() {
    NextFlixTheme {
        SerieGrid(
            flowOf(PagingData.from(Serie.listaStub)).collectAsLazyPagingItems()
        )
    }
}
