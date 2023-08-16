package app.vazovsky.starwars.data.model

data class Character(
    val id: Int,
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val homeworld: String,
    val filmsId: List<Int> = emptyList(),
    val speciesId: List<Int> = emptyList(),
    val vehiclesId: List<Int> = emptyList(),
    val starshipsId: List<Int> = emptyList(),
)