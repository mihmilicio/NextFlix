package io.github.mihmilicio.nextflix.ui.features.watchlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme

@Composable
fun WatchlistScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets(bottom = 0.dp)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            WatchlistList(series = DetalheDaSerie.listaStub)
        }
    }
}


@Preview
@Composable
fun WatchlistPreview() {
    NextFlixTheme {
        WatchlistScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}