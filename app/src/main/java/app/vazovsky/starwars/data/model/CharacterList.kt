package app.vazovsky.starwars.data.model

data class CharacterList(
    val count: Long,
    val next: String?,
    val previous: String?,
    val characters: List<Character> = emptyList(),
)