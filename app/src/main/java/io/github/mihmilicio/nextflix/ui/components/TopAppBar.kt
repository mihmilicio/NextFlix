package io.github.mihmilicio.nextflix.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme

@Composable
fun TopAppBarSurface(
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.surfaceContainer)
            .padding(12.dp),
        content = content
    )
}

@Preview
@Composable
fun TopAppBarSurfacePreview() {
    NextFlixTheme {
        TopAppBarSurface {
            SearchBarView(
                query = "",
                onQueryChange = {},
                onSearch = {},
                placeholderText = "Buscar..."
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NextFlixAppBar(
    titulo: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(titulo) },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    )
}