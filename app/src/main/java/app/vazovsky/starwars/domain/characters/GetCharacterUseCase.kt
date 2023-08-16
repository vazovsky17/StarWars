package app.vazovsky.starwars.domain.characters

import app.vazovsky.starwars.data.model.Character
import app.vazovsky.starwars.data.repository.CharactersRepository
import app.vazovsky.starwars.domain.base.usecase.UseCaseUnary
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository,
) : UseCaseUnary<GetCharacterUseCase.Params, Character>() {
    override suspend fun execute(params: Params): Character {
        return charactersRepository.getCharacterById(params.id)
    }

    data class Params(
        val id: Int,
    )
}