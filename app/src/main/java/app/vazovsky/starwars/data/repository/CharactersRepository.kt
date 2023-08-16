package app.vazovsky.starwars.data.repository

import app.vazovsky.starwars.data.model.Character
import app.vazovsky.starwars.data.model.CharacterList

interface CharactersRepository {

    suspend fun getCharacters(page: Int? = 1, search: String? = null): CharacterList

    suspend fun getCharacterById(id: Int): Character

}