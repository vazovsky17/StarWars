package app.vazovsky.starwars.data.model

data class Film(
    val id: Int,
    val title: String,
    val episodeId: Int,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val releaseDate: String,
    val charactersId: List<Int> = emptyList(),
    val planetsId: List<Int> = emptyList(),
    val starshipsId: List<Int> = emptyList(),
    val vehiclesId: List<Int> = emptyList(),
    val speciesId: List<Int> = emptyList(),
)