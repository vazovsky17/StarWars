package app.vazovsky.starwars.data.repository

import app.vazovsky.starwars.data.mapper.StarshipMapper
import app.vazovsky.starwars.data.model.Starship
import app.vazovsky.starwars.data.model.StarshipList
import app.vazovsky.starwars.data.remote.StarWarsApiService
import javax.inject.Inject

class StarshipsRepositoryImpl @Inject constructor(
    private val apiService: StarWarsApiService,
    private val starshipMapper: StarshipMapper,
) : StarshipsRepository {
    override suspend fun getStarships(page: Int?, search: String?): StarshipList {
        return starshipMapper.fromApiToModel(apiService.getStarships(page, search))
    }

    override suspend fun getStarshipById(id: Int): Starship {
        return starshipMapper.fromApiToModel(apiService.getStarshipById(id))
    }
}