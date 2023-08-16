package app.vazovsky.starwars.domain.characters

import app.vazovsky.starwars.data.model.Character
import app.vazovsky.starwars.data.repository.CharactersRepository
import app.vazovsky.starwars.domain.base.paging.BasePagingSource

class CharacterPagingSource(
    query: String?,
    private val charactersRepository: CharactersRepository,
) : BasePagingSource<Character>(query) {
    override suspend fun loadPage(offset: Int, limit: Int, query: String?): List<Character> {
        return charactersRepository.getCharacters(page = offset).characters
    }
}