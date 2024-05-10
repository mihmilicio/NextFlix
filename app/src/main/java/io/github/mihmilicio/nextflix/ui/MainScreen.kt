package io.github.mihmilicio.nextflix.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.github.mihmilicio.nextflix.R
import io.github.mihmilicio.nextflix.ui.features.catalogo.CatalogoScreen
import io.github.mihmilicio.nextflix.ui.features.watchlist.WatchlistScreen

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NextFlixAppBar(
    currentScreen: RouteEnum,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.btn_voltar_alt_text)
                    )
                }
            }
        }
    )
}

@Composable
fun NextFlixNavigationBar(
    currentScreen: RouteEnum,
    navigateToRoute: (route: RouteEnum) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = RouteEnum.entries

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { _, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        item.icon, contentDescription = stringResource(item.iconContentDescription)
                    )
                },
                label = { Text(stringResource(item.title)) },
                selected = currentScreen == item,
                onClick = { navigateToRoute(item) }
            )
        }
    }
}

@Composable
fun NextFlixApp(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = RouteEnum.valueOf(
        backStackEntry?.destination?.route ?: RouteEnum.START_ROUTE.name
    )

    Scaffold(
        topBar = {
            NextFlixAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
        bottomBar = {
            NextFlixNavigationBar(
                currentScreen = currentScreen,
                navigateToRoute = { navController.navigate(it.name) }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RouteEnum.START_ROUTE.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = RouteEnum.Watchlist.name) {
                WatchlistScreen()
            }
            composable(route = RouteEnum.Catalogo.name) {
                CatalogoScreen()
            }
        }
    }
}

@Preview
@Composable
fun NextFlixAppPreview() {
    NextFlixApp()
}
