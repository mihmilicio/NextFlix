package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import io.github.mihmilicio.nextflix.data.Serie
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
        // TODO loadStates
    }
}

@Preview
@Composable
fun SerieGridPreview() {
    NextFlixTheme {
        SerieGrid(flowOf(PagingData.from(Serie.listaStub)).collectAsLazyPagingItems())
    }
}
