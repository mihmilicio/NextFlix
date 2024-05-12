package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.mihmilicio.nextflix.data.Serie
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme

@Composable
fun SerieGrid(series: List<Serie>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(series) { _, serie ->
            SerieCard(serie)
        }
    }
}

@Preview
@Composable
fun SerieGridPreview() {
    NextFlixTheme {
        SerieGrid(Serie.listaStub)
    }
}
