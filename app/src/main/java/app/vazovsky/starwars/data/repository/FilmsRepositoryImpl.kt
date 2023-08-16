package app.vazovsky.starwars.data.repository

import app.vazovsky.starwars.data.mapper.FilmMapper
import app.vazovsky.starwars.data.model.Film
import app.vazovsky.starwars.data.remote.StarWarsApiService
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(
    private val apiService: StarWarsApiService,
    private val filmMapper: FilmMapper,
) : FilmsRepository {
    override suspend fun getFilmById(id: Int): Film {
        return filmMapper.fromApiToModel(apiService.getFilmById(id))
    }
}