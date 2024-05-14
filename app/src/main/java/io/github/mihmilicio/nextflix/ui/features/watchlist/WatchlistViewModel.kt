package io.github.mihmilicio.nextflix.ui.features.watchlist

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mihmilicio.nextflix.domain.model.SerieParaAssistir
import io.github.mihmilicio.nextflix.domain.usecase.ListarSeriesParaAssistirUseCase
import io.github.mihmilicio.nextflix.domain.usecase.MarcarEpisodioAssistidoUseCase
import javax.inject.Inject

@HiltViewModel
class WatchlistViewModel @Inject constructor(
    private val listarSeriesParaAssistirUseCase: ListarSeriesParaAssistirUseCase,
    private val marcarEpisodioAssistidoUseCase: MarcarEpisodioAssistidoUseCase

) : ViewModel() {

    var series = mutableStateListOf<SerieParaAssistir>()

    init {
        series.addAll(listarSeriesParaAssistirUseCase())
    }

    fun marcarEpisodioAssistido(serie: SerieParaAssistir) {
        marcarEpisodioAssistidoUseCase(serie)

        val seriesAtualizadas = listarSeriesParaAssistirUseCase()
        val serieAssistida: (SerieParaAssistir) -> Boolean = { it.id == serie.id }

        series.removeIf(serieAssistida)

        val serieAssistidaAtualizada = seriesAtualizadas.find(serieAssistida)
        if (serieAssistidaAtualizada != null)
            series.add(0, serieAssistidaAtualizada)
    }

}