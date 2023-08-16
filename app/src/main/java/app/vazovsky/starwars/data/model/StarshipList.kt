package app.vazovsky.starwars.data.model

data class StarshipList(
    val count: Long,
    val next: String?,
    val previous: String?,
    val starships: List<Starship> = emptyList(),
)