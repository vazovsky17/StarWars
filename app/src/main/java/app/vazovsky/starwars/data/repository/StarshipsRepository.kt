package app.vazovsky.starwars.data.repository

import app.vazovsky.starwars.data.model.Starship
import app.vazovsky.starwars.data.model.StarshipList

interface StarshipsRepository {

    suspend fun getStarships(page: Int? = 1, search: String? = null): StarshipList

    suspend fun getStarshipById(id: Int): Starship

}