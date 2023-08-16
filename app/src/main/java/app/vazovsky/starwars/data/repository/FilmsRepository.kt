package app.vazovsky.starwars.data.repository

import app.vazovsky.starwars.data.model.Film

interface FilmsRepository {

    suspend fun getFilmById(id: Int): Film

}