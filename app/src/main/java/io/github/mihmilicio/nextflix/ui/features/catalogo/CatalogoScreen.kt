package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme

@Composable
fun CatalogoScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Catálogo works!",
                style = MaterialTheme.typography.headlineSmall
            )
        }
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