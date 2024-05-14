package io.github.mihmilicio.nextflix.ui.features.watchlist

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mihmilicio.nextflix.domain.model.SerieParaAssistir
import io.github.mihmilicio.nextflix.domain.usecase.ListarSeriesParaAssistirUseCase
import io.github.mihmilicio.nextflix.domain.usecase.MarcarEpisodioAssistidoUseCase
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

@OptIn(FlowPreview::class)
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

        val episodiosAtualizados = listarSeriesParaAssistirUseCase()

//        val index = series.indexOf(episodio)
        val index = series.indexOfFirst { it.id == serie.id }
        series[index] = episodiosAtualizados[index]
    }

}