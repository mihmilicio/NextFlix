package io.github.mihmilicio.nextflix.ui

import androidx.annotation.StringRes
import io.github.mihmilicio.nextflix.R

enum class RouteEnum (@StringRes val title: Int) {
    Watchlist(title = R.string.watchlist_titulo),
    Catalogo(title = R.string.catalogo_titulo);

    companion object {
        val START_ROUTE = Watchlist
    }
}