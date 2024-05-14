package io.github.mihmilicio.nextflix.ui.features.watchlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.mihmilicio.nextflix.R
import io.github.mihmilicio.nextflix.ui.components.NextFlixAppBar
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme

@Composable
fun WatchlistScreen(
    modifier: Modifier = Modifier,
    viewModel: WatchlistViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets(bottom = 0.dp),
        topBar = {
            NextFlixAppBar(stringResource(R.string.watchlist_titulo))
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            WatchlistList(
                series = viewModel.series,
                marcarEpisodioAssistido = { viewModel.marcarEpisodioAssistido(it) })
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