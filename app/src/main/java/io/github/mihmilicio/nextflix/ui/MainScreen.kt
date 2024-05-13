package io.github.mihmilicio.nextflix.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import io.github.mihmilicio.nextflix.ui.features.catalogo.CatalogoScreen
import io.github.mihmilicio.nextflix.ui.features.watchlist.WatchlistScreen

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
                .padding(bottom = innerPadding.calculateBottomPadding())
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
