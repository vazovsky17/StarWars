package app.vazovsky.starwars.data.repository

import app.vazovsky.starwars.data.mapper.CharacterMapper
import app.vazovsky.starwars.data.model.Character
import app.vazovsky.starwars.data.model.CharacterList
import app.vazovsky.starwars.data.remote.StarWarsApiService
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val apiService: StarWarsApiService,
    private val characterMapper: CharacterMapper,
) : CharactersRepository {
    override suspend fun getCharacters(page: Int?, search: String?): CharacterList {
        return characterMapper.fromApiToModel(apiService.getCharacters(page, search))
    }

    override suspend fun getCharacterById(id: Int): Character {
        return characterMapper.fromApiToModel(apiService.getCharacterById(id))
    }
}