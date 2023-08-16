package app.vazovsky.starwars.data.remote

import app.vazovsky.starwars.data.remote.response.CharacterListResponse
import app.vazovsky.starwars.data.remote.response.CharacterResponse
import app.vazovsky.starwars.data.remote.response.FilmResponse
import app.vazovsky.starwars.data.remote.response.StarshipListResponse
import app.vazovsky.starwars.data.remote.response.StarshipResponse

class MockStarWarsApiService : StarWarsApiService {
    private val characters = listOf(
        CharacterResponse(
            name = "Luke Skywalker",
            height = "172",
            mass = "77",
            hairColor = "blond",
            skinColor = "fair",
            eyeColor = "blue",
            birthYear = "19BBY",
            gender = "male",
            homeworld = "https://swapi.dev/api/planets/1/",
            filmsUrl = listOf(
                "https://swapi.dev/api/films/1/",
                "https://swapi.dev/api/films/2/",
                "https://swapi.dev/api/films/3/",
                "https://swapi.dev/api/films/6/",
            ),
            species = listOf(),
            vehicles = listOf(
                "https://swapi.dev/api/vehicles/14/", "https://swapi.dev/api/vehicles/30/"
            ),
            starships = listOf(
                "https://swapi.dev/api/starships/12/",
                "https://swapi.dev/api/starships/22/",
            ),
            url = "https://swapi.dev/api/people/0/",
        ), CharacterResponse(
            name = "C-3PO",
            height = "167",
            mass = "75",
            hairColor = "n/a",
            skinColor = "gold",
            eyeColor = "yellow",
            birthYear = "112BBY",
            gender = "n/a",
            homeworld = "https://swapi.dev/api/planets/1/",
            filmsUrl = listOf(
                "https://swapi.dev/api/films/1/",
                "https://swapi.dev/api/films/2/",
                "https://swapi.dev/api/films/3/",
                "https://swapi.dev/api/films/4/",
                "https://swapi.dev/api/films/5/",
                "https://swapi.dev/api/films/6/",
            ),
            species = listOf(
                "https://swapi.dev/api/species/2/",
            ),
            vehicles = listOf(),
            starships = listOf(),
            url = "https://swapi.dev/api/people/1/",
        )
    )

    private val starships = listOf(
        StarshipResponse(
            name = "CR90 corvette",
            model = "CR90 corvette",
            manufacturer = "Corellian Engineering Corporation",
            costInCredits = "3500000",
            length = "150",
            maxAtmospheringSpeed = "950",
            crew = "30-165",
            passengers = "600",
            cargoCapacity = "3000000",
            consumables = "1 year",
            hyperdriveRating = "2.0",
            mglt = "60",
            starshipClass = "corvette",
            pilots = listOf(),
            filmsUrl = listOf(
                "https://swapi.dev/api/films/1/",
                "https://swapi.dev/api/films/3/",
                "https://swapi.dev/api/films/6/"
            ),
            url = "https://swapi.dev/api/starships/0/",
        ),
        StarshipResponse(
            name = "Star Destroyer",
            model = "Imperial I-class Star Destroyer",
            manufacturer = "Kuat Drive Yards",
            costInCredits = "150000000",
            length = "1,600",
            maxAtmospheringSpeed = "975",
            crew = "47,060",
            passengers = "n/a",
            cargoCapacity = "36000000",
            consumables = "2 years",
            hyperdriveRating = "2.0",
            mglt = "60",
            starshipClass = "Star Destroyer",
            pilots = listOf(),
            filmsUrl = listOf(
                "https://swapi.dev/api/films/1/",
                "https://swapi.dev/api/films/2/",
                "https://swapi.dev/api/films/3/"
            ),
            url = "https://swapi.dev/api/starships/1/",
        )
    )

    override suspend fun getCharacters(page: Int?, search: String?): CharacterListResponse {
        return CharacterListResponse(
            count = 82,
            next = "https://swapi.dev/api/people/?page=2",
            previous = null,
            results = characters
        )
    }

    override suspend fun getCharacterById(id: Int): CharacterResponse {
        return characters[id]
    }

    override suspend fun getStarships(page: Int?, search: String?): StarshipListResponse {
        return StarshipListResponse(
            count = 36,
            next = "https://swapi.dev/api/starships/?page=2",
            previous = null,
            results = starships,
        )
    }

    override suspend fun getStarshipById(id: Int): StarshipResponse {
        return starships[id]
    }

    override suspend fun getFilmById(id: Int): FilmResponse {
        return FilmResponse(
            title = "A New Hope",
            episodeId = 4,
            openingCrawl = "It is a period of civil war.\\r\\nRebel spaceships, striking\\r\\nfrom a hidden base, have won\\r\\ntheir first victory against\\r\\nthe evil Galactic Empire.\\r\\n\\r\\nDuring the battle, Rebel\\r\\nspies managed to steal secret\\r\\nplans to the Empire's\\r\\nultimate weapon, the DEATH\\r\\nSTAR, an armored space\\r\\nstation with enough power\\r\\nto destroy an entire planet.\\r\\n\\r\\nPursued by the Empire's\\r\\nsinister agents, Princess\\r\\nLeia races home aboard her\\r\\nstarship, custodian of the\\r\\nstolen plans that can save her\\r\\npeople and restore\\r\\nfreedom to the galaxy....",
            director = "George Lucas",
            producer = "Gary Kurtz, Rick McCallum",
            releaseDate = "1977-05-25",
            characters = listOf(
                "https://swapi.dev/api/people/1/",
                "https://swapi.dev/api/people/2/",
                "https://swapi.dev/api/people/3/",
                "https://swapi.dev/api/people/4/",
                "https://swapi.dev/api/people/5/",
                "https://swapi.dev/api/people/6/",
                "https://swapi.dev/api/people/7/",
                "https://swapi.dev/api/people/8/",
                "https://swapi.dev/api/people/9/",
                "https://swapi.dev/api/people/10/",
                "https://swapi.dev/api/people/12/",
                "https://swapi.dev/api/people/13/",
                "https://swapi.dev/api/people/14/",
                "https://swapi.dev/api/people/15/",
                "https://swapi.dev/api/people/16/",
                "https://swapi.dev/api/people/18/",
                "https://swapi.dev/api/people/19/",
                "https://swapi.dev/api/people/81/"
            ),
            planets = listOf(
                "https://swapi.dev/api/planets/1/",
                "https://swapi.dev/api/planets/2/",
                "https://swapi.dev/api/planets/3/"
            ),
            starships = listOf(
                "https://swapi.dev/api/starships/2/",
                "https://swapi.dev/api/starships/3/",
                "https://swapi.dev/api/starships/5/",
                "https://swapi.dev/api/starships/9/",
                "https://swapi.dev/api/starships/10/",
                "https://swapi.dev/api/starships/11/",
                "https://swapi.dev/api/starships/12/",
                "https://swapi.dev/api/starships/13/"
            ),
            vehicles = listOf(
                "https://swapi.dev/api/vehicles/4/",
                "https://swapi.dev/api/vehicles/6/",
                "https://swapi.dev/api/vehicles/7/",
                "https://swapi.dev/api/vehicles/8/"
            ),
            species = listOf(
                "https://swapi.dev/api/species/1/",
                "https://swapi.dev/api/species/2/",
                "https://swapi.dev/api/species/3/",
                "https://swapi.dev/api/species/4/",
                "https://swapi.dev/api/species/5/"
            ),
            url = "https://swapi.dev/api/films/1/"
        )
    }
}