package io.github.mihmilicio.nextflix.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.mihmilicio.nextflix.R

enum class RouteEnum(
    @StringRes val title: Int,
    val icon: ImageVector,
    @StringRes val iconContentDescription: Int
) {
    Watchlist(
        title = R.string.watchlist_titulo,
        icon = Icons.Outlined.Bookmarks,
        iconContentDescription = R.string.watchlist_icon_content_description
    ),
    Catalogo(
        title = R.string.catalogo_titulo,
        icon = Icons.AutoMirrored.Outlined.MenuBook,
        iconContentDescription = R.string.catalogo_icon_content_description
    );

    companion object {
        val START_ROUTE = Watchlist
    }
}