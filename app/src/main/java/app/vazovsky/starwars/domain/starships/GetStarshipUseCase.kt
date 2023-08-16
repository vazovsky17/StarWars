package app.vazovsky.starwars.domain.starships

import app.vazovsky.starwars.data.model.Starship
import app.vazovsky.starwars.data.repository.StarshipsRepository
import app.vazovsky.starwars.domain.base.usecase.UseCaseUnary
import javax.inject.Inject

class GetStarshipUseCase @Inject constructor(
    private val starshipsRepository: StarshipsRepository
) : UseCaseUnary<GetStarshipUseCase.Params, Starship>() {
    override suspend fun execute(params: Params): Starship {
        return starshipsRepository.getStarshipById(params.id)
    }

    data class Params(
        val id: Int,
    )
}