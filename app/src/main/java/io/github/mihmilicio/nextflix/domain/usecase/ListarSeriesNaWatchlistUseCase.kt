package io.github.mihmilicio.nextflix.domain.usecase

import io.github.mihmilicio.nextflix.data.repository.WatchlistRepository
import io.github.mihmilicio.nextflix.domain.model.DetalheDaSerie
import javax.inject.Inject

class ListarSeriesNaWatchlistUseCase @Inject constructor(
    private val watchlistRepository: WatchlistRepository
) {

    operator fun invoke(): List<DetalheDaSerie> = watchlistRepository.listarSeriesNaWatchlist()
}