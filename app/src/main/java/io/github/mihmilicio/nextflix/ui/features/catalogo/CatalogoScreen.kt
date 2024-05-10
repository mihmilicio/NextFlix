package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.mihmilicio.nextflix.data.Serie
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme


val items = listOf(
    Serie(
        id = 35624,
        nome = "The Flash",
        link = "the-flash",
        posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg"
    ),
    Serie(
        id = 35624,
        nome = "The Flash texto muito longo nesse aqui pra ver como fica",
        link = "the-flash",
        posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg"
    ),
    Serie(
        id = 35624,
        nome = "The Flash",
        link = "the-flash",
        posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg"
    ),
    Serie(
        id = 35624,
        nome = "The Flash",
        link = "the-flash",
        posterUrl = ""
    ),
    Serie(
        id = 35624,
        nome = "The Flash",
        link = "the-flash",
        posterUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg"
    )
)


@Composable
fun CatalogoScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        // TODO search bar
        SerieGrid(series = items)
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
