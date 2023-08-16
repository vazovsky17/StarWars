package app.vazovsky.starwars.domain.fims

import app.vazovsky.starwars.data.model.Film
import app.vazovsky.starwars.data.repository.FilmsRepository
import app.vazovsky.starwars.domain.base.usecase.UseCaseUnary
import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
    private val filmsRepository: FilmsRepository,
) : UseCaseUnary<GetFilmUseCase.Params, Film>() {
    override suspend fun execute(params: Params): Film {
        return filmsRepository.getFilmById(params.id)
    }

    data class Params(
        val id: Int,
    )
}