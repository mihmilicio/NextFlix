package io.github.mihmilicio.nextflix.ui.features.watchlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.mihmilicio.nextflix.domain.model.EpisodioDaWatchlist
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme

@Composable
fun WatchlistList(
    episodios: List<EpisodioDaWatchlist>,
    marcarEpisodioAssistido: (EpisodioDaWatchlist) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(episodios) { episodio ->
            EpisodioCard(episodio = episodio, marcarEpisodioAssistido = marcarEpisodioAssistido)
        }
    }
}


@Preview
@Composable
fun SerieGridPreview() {
    NextFlixTheme {
        WatchlistList(EpisodioDaWatchlist.listaStub, marcarEpisodioAssistido = {})
    }
}
