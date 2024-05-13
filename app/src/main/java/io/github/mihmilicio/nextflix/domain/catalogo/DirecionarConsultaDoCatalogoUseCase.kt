package io.github.mihmilicio.nextflix.domain.catalogo

import io.github.mihmilicio.nextflix.data.dto.ListagemDeSeriesDto
import javax.inject.Inject

class DirecionarConsultaDoCatalogoUseCase @Inject constructor(
    private val listarSeriesPopularesUseCase: ListarSeriesPopularesUseCase,
    private val buscarSeriesUseCase: BuscarSeriesUseCase
) {

    suspend operator fun invoke(pagina: Int, busca: String): ListagemDeSeriesDto =
        if (busca.isBlank()) {
            listarSeriesPopularesUseCase(pagina = pagina)
        } else
            buscarSeriesUseCase(pagina = pagina, busca = busca)

}