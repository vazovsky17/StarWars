package app.vazovsky.starwars.data.model

data class Starship(
    val id: Int,
    val name: String,
    val model: String,
    val manufacturer: String,
    val costInCredits: String,
    val length: String,
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val hyperdriveRating: String,
    val mglt: String,
    val starshipClass: String,
    val pilotsId: List<Int> = emptyList(),
    val filmsId: List<Int> = emptyList(),
)