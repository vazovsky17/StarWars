package app.vazovsky.starwars.data.remote

class SemimockStarWarsApiService(
    private val apiService: StarWarsApiService,
    private val mockApiService: MockStarWarsApiService,
) : StarWarsApiService {
}