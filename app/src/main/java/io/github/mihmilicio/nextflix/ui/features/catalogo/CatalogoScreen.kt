package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import io.github.mihmilicio.nextflix.data.Serie
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme


@Composable
fun CatalogoScreen(
    modifier: Modifier = Modifier,
    viewModel: CatalogoViewModel = hiltViewModel()
) {
    val seriePagingItems: LazyPagingItems<Serie> = viewModel.seriesPaging.collectAsLazyPagingItems()

    Column(
        modifier = modifier
    ) {
        // TODO search bar
        SerieGrid(seriePagingItems = seriePagingItems)
    }
}

@Preview
@Composable
fun CatalogoPreview() {
    NextFlixTheme {
        CatalogoScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}
