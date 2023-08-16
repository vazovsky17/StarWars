package app.vazovsky.starwars.data.mapper

import app.vazovsky.starwars.data.model.Character
import app.vazovsky.starwars.data.model.CharacterList
import app.vazovsky.starwars.data.remote.response.CharacterListResponse
import app.vazovsky.starwars.data.remote.response.CharacterResponse
import app.vazovsky.starwars.extensions.orDefault
import app.vazovsky.starwars.managers.IdFromUrlManager
import javax.inject.Inject

class CharacterMapper @Inject constructor(
    private val idFromUrlManager: IdFromUrlManager,
) {

    fun fromApiToModel(apiModel: CharacterListResponse?): CharacterList {
        return CharacterList(
            count = apiModel?.count.orDefault(),
            next = apiModel?.next,
            previous = apiModel?.previous,
            characters = apiModel?.results.orEmpty().map { fromApiToModel(it) }
        )
    }

    fun fromApiToModel(apiModel: CharacterResponse?): Character {
        return Character(
            id = apiModel?.url?.let { idFromUrlManager.fromUrlToId(it) }.orDefault(),
            name = apiModel?.name.orDefault(),
            height = apiModel?.height.orDefault(),
            mass = apiModel?.mass.orDefault(),
            hairColor = apiModel?.hairColor.orDefault(),
            skinColor = apiModel?.skinColor.orDefault(),
            eyeColor = apiModel?.eyeColor.orDefault(),
            birthYear = apiModel?.birthYear.orDefault(),
            gender = apiModel?.gender.orDefault(),
            homeworld = apiModel?.homeworld.orDefault(),
            filmsId = apiModel?.filmsUrl.orEmpty().map { idFromUrlManager.fromUrlToId(it) },
            speciesId = apiModel?.species.orEmpty().map { idFromUrlManager.fromUrlToId(it) },
            vehiclesId = apiModel?.vehicles.orEmpty().map { idFromUrlManager.fromUrlToId(it) },
            starshipsId = apiModel?.starships.orEmpty().map { idFromUrlManager.fromUrlToId(it) }
        )
    }
}