package io.github.mihmilicio.nextflix.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarView(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    placeholderText: String,
    modifier: Modifier = Modifier
) {
    SearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = onSearch,
        active = false,
        onActiveChange = {},
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        placeholder = { Text(placeholderText) },
        modifier = modifier
    ) {}
}

@Preview
@Composable
fun SearchBarViewPreview() {
    NextFlixTheme {
        SearchBarView(
            query = "",
            onQueryChange = {},
            onSearch = {},
            placeholderText = "Buscar..."
        )
    }
}