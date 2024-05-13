package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.github.mihmilicio.nextflix.domain.model.Serie
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme


@Composable
fun SerieCard(
    serie: Serie,
    onAdicionarSerie: (Serie) -> Unit
) {
    OutlinedCard(
        modifier = Modifier.sizeIn(maxWidth = 250.dp)
    ) {
        Box {
            AsyncImage(
                model = serie.posterUrl,
                contentDescription = serie.nome,
                modifier = Modifier
                    .aspectRatio(0.75f)
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            FilledTonalIconButton(
                onClick = { onAdicionarSerie(serie) },
                shape = MaterialTheme.shapes.extraSmall,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(36.dp)
            ) {
                Icon(Icons.Default.Bookmark, contentDescription = null)
            }
        }

        Text(
            text = serie.nome,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@Preview
@Composable
fun SerieCardPreview() {
    NextFlixTheme {
        SerieCard(serie = Serie.stub, onAdicionarSerie = {})
    }
}