package app.vazovsky.starwars.data.remote

import app.vazovsky.starwars.data.remote.response.CharacterListResponse
import app.vazovsky.starwars.data.remote.response.CharacterResponse
import app.vazovsky.starwars.data.remote.response.FilmResponse
import app.vazovsky.starwars.data.remote.response.StarshipListResponse
import app.vazovsky.starwars.data.remote.response.StarshipResponse

class SemimockStarWarsApiService(
    private val apiService: StarWarsApiService,
    private val mockApiService: MockStarWarsApiService,
) : StarWarsApiService {
    override suspend fun getCharacters(page: Long?, search: String?): CharacterListResponse {
        return mockApiService.getCharacters(page, search)
    }

    override suspend fun getCharacterById(id: Long): CharacterResponse {
        return mockApiService.getCharacterById(id)
    }

    override suspend fun getStarships(page: Long?, search: String?): StarshipListResponse {
        return mockApiService.getStarships(page, search)
    }

    override suspend fun getStarshipById(id: Long): StarshipResponse {
        return mockApiService.getStarshipById(id)
    }

    override suspend fun getFilmById(id: Long): FilmResponse {
        return mockApiService.getFilmById(id)
    }
}