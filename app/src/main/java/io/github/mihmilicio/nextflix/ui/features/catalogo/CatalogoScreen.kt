package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme


@Composable
fun CatalogoScreen(
    modifier: Modifier = Modifier,
    viewModel: CatalogoViewModel = hiltViewModel()
) {
    val series by viewModel.series.collectAsState()

    Column(
        modifier = modifier
    ) {
        // TODO search bar
        SerieGrid(series = series)
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
