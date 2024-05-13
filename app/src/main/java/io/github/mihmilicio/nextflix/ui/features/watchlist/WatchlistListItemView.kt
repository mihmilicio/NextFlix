package io.github.mihmilicio.nextflix.ui.features.watchlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.github.mihmilicio.nextflix.domain.model.EpisodioDaWatchlist
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme


@Composable
fun EpisodioCard(
    episodio: EpisodioDaWatchlist,
    marcarEpisodioComoAssistido: (EpisodioDaWatchlist) -> Unit
) {
    OutlinedCard {
        ListItem(
            leadingContent = {
                AsyncImage(
                    model = episodio.foto,
                    contentDescription = episodio.serie.nome,
                    modifier = Modifier
                        .height(64.dp)
                        .aspectRatio(4 / 3f)
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                    contentScale = ContentScale.Crop
                )
            },
            headlineContent = {
                Text(
                    text = episodio.serie.nome,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            },
            supportingContent = {
                Text(
                    text = "S${episodio.temporada}E${episodio.episodio}: ${episodio.nome}",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            },
            trailingContent = {
                Checkbox(
                    checked = false,
                    onCheckedChange = { marcarEpisodioComoAssistido(episodio) })
            }
        )
    }
}

@Preview
@Composable
fun SerieCardPreview() {
    NextFlixTheme {
        EpisodioCard(episodio = EpisodioDaWatchlist.stub, marcarEpisodioComoAssistido = {})
    }
}