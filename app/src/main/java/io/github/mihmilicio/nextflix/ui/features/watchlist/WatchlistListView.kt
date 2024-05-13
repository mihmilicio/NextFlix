package io.github.mihmilicio.nextflix.ui.features.watchlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme

@Composable
fun WatchlistList(series: List<DetalheDaSerie>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(series) { serie ->
            EpisodioCard(serie)
        }
    }
}


@Preview
@Composable
fun SerieGridPreview() {
    NextFlixTheme {
        WatchlistList(DetalheDaSerie.listaStub)
    }
}
