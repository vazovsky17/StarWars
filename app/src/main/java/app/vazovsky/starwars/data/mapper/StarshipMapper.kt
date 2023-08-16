package app.vazovsky.starwars.data.mapper

import app.vazovsky.starwars.data.model.Starship
import app.vazovsky.starwars.data.model.StarshipList
import app.vazovsky.starwars.data.remote.response.StarshipListResponse
import app.vazovsky.starwars.data.remote.response.StarshipResponse
import app.vazovsky.starwars.extensions.orDefault
import app.vazovsky.starwars.managers.IdFromUrlManager
import javax.inject.Inject

class StarshipMapper @Inject constructor(
    private val idFromUrlManager: IdFromUrlManager,
) {

    fun fromApiToModel(apiModel: StarshipListResponse?): StarshipList {
        return StarshipList(
            count = apiModel?.count.orDefault(),
            next = apiModel?.next,
            previous = apiModel?.previous,
            starships = apiModel?.results.orEmpty().map { fromApiToModel(it) }
        )
    }

    fun fromApiToModel(apiModel: StarshipResponse?): Starship {
        return Starship(
            id = apiModel?.url?.let { idFromUrlManager.fromUrlToId(it) }.orDefault(),
            name = apiModel?.name.orDefault(),
            model = apiModel?.model.orDefault(),
            manufacturer = apiModel?.manufacturer.orDefault(),
            costInCredits = apiModel?.costInCredits.orDefault(),
            length = apiModel?.length.orDefault(),
            maxAtmospheringSpeed = apiModel?.maxAtmospheringSpeed.orDefault(),
            crew = apiModel?.crew.orDefault(),
            passengers = apiModel?.passengers.orDefault(),
            cargoCapacity = apiModel?.cargoCapacity.orDefault(),
            consumables = apiModel?.consumables.orDefault(),
            hyperdriveRating = apiModel?.hyperdriveRating.orDefault(),
            mglt = apiModel?.mglt.orDefault(),
            starshipClass = apiModel?.starshipClass.orDefault(),
            pilotsId = apiModel?.pilots.orEmpty().map { idFromUrlManager.fromUrlToId(it) },
            filmsId = apiModel?.filmsUrl.orEmpty().map { idFromUrlManager.fromUrlToId(it) },
        )
    }
}