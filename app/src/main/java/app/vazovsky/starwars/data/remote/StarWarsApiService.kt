package app.vazovsky.starwars.data.remote

import app.vazovsky.starwars.data.remote.response.CharacterListResponse
import app.vazovsky.starwars.data.remote.response.CharacterResponse
import app.vazovsky.starwars.data.remote.response.FilmResponse
import app.vazovsky.starwars.data.remote.response.StarshipListResponse
import app.vazovsky.starwars.data.remote.response.StarshipResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsApiService {

    @GET("people")
    suspend fun getCharacters(
        @Query("page") page: Int?,
        @Query("search") search: String?,
    ): CharacterListResponse

    @GET("people/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int
    ): CharacterResponse

    @GET("starships")
    suspend fun getStarships(
        @Query("page") page: Int?,
        @Query("search") search: String?,
    ): StarshipListResponse

    @GET("starships/{id}")
    suspend fun getStarshipById(
        @Path("id") id: Int
    ): StarshipResponse

    @GET("films/{id}")
    suspend fun getFilmById(
        @Path("id") id: Int,
    ): FilmResponse
}