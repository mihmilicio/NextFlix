package io.github.mihmilicio.nextflix.ui.features.watchlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.github.mihmilicio.nextflix.R
import io.github.mihmilicio.nextflix.domain.model.SerieParaAssistir
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme


@Composable
fun EpisodioCard(
    serie: SerieParaAssistir,
    marcarEpisodioAssistido: (SerieParaAssistir) -> Unit,
    irParaOTopo: () -> Unit
) {
    OutlinedCard {
        ListItem(
            leadingContent = {
                AsyncImage(
                    model = serie.foto,
                    contentDescription = serie.nome,
                    modifier = Modifier
                        .height(64.dp)
                        .aspectRatio(4 / 3f)
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                    contentScale = ContentScale.Crop
                )
            },
            headlineContent = {
                Text(
                    text = serie.nome,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            },
            supportingContent = {
                serie.episodio.apply {
                    Text(
                        text = "S${temporada}E${episodio}: $nome",
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            },
            trailingContent = {
                FilledTonalIconButton(onClick = {
                    marcarEpisodioAssistido(serie)
                    irParaOTopo()
                }) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = stringResource(R.string.watchlist_btn_assistido_content_description)
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun SerieCardPreview() {
    NextFlixTheme {
        EpisodioCard(serie = SerieParaAssistir.stub, marcarEpisodioAssistido = {}, irParaOTopo = {})
    }
}