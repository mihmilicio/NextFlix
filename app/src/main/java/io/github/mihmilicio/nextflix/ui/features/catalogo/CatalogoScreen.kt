package io.github.mihmilicio.nextflix.ui.features.catalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import io.github.mihmilicio.nextflix.R
import io.github.mihmilicio.nextflix.domain.model.Serie
import io.github.mihmilicio.nextflix.ui.components.SearchBarView
import io.github.mihmilicio.nextflix.ui.components.TopAppBarSurface
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme


@Composable
fun CatalogoScreen(
    viewModel: CatalogoViewModel = hiltViewModel()
) {
    val seriePagingItems: LazyPagingItems<Serie> = viewModel.seriesPaging.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBarSurface {
                SearchBarView(
                    query = viewModel.textoCampoDeBusca,
                    onQueryChange = { viewModel.atualizarTextoDeBusca(it) },
                    onSearch = { viewModel.atualizarQueryDeBusca(it) },
                    placeholderText = stringResource(R.string.catalogo_textfield_busca_placeholder),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }, contentWindowInsets = WindowInsets(bottom = 0.dp)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            SerieGrid(
                seriePagingItems = seriePagingItems,
                onAdicionarSerie = { viewModel.adicionarSerie(it) })
        }
    }

}

@Preview
@Composable
fun CatalogoPreview() {
    NextFlixTheme {
        CatalogoScreen()
    }
}
