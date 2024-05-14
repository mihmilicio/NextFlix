package io.github.mihmilicio.nextflix.ui.features.watchlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LiveTv
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.mihmilicio.nextflix.R
import io.github.mihmilicio.nextflix.domain.model.SerieParaAssistir
import io.github.mihmilicio.nextflix.ui.components.MensagemFeedback
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme

@Composable
fun WatchlistList(
    series: List<SerieParaAssistir>,
    marcarEpisodioAssistido: (SerieParaAssistir) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (series.isEmpty()) {
            item {
                MensagemFeedback(
                    titulo = stringResource(R.string.watchlist_empty_state_titulo),
                    corpo = stringResource(R.string.watchlist_empty_state_corpo),
                    icone = Icons.Outlined.LiveTv
                )
            }
        }
        items(series) { episodio ->
            EpisodioCard(serie = episodio, marcarEpisodioAssistido = marcarEpisodioAssistido)
        }
    }
}


@Preview
@Composable
fun SerieGridPreview() {
    NextFlixTheme {
        WatchlistList(emptyList(), marcarEpisodioAssistido = {})
    }
}
