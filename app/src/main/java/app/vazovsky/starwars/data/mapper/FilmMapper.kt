package app.vazovsky.starwars.data.mapper

import app.vazovsky.starwars.data.model.Film
import app.vazovsky.starwars.data.remote.response.FilmResponse
import app.vazovsky.starwars.extensions.orDefault
import app.vazovsky.starwars.managers.IdFromUrlManager
import javax.inject.Inject

class FilmMapper @Inject constructor(
    private val idFromUrlManager: IdFromUrlManager,
) {

    fun fromApiToModel(apiModel: FilmResponse?): Film {
        return Film(
            id = apiModel?.url?.let { idFromUrlManager.fromUrlToId(it) }.orDefault(),
            title = apiModel?.title.orDefault(),
            episodeId = apiModel?.episodeId.orDefault(),
            openingCrawl = apiModel?.openingCrawl.orDefault(),
            director = apiModel?.director.orDefault(),
            producer = apiModel?.producer.orDefault(),
            releaseDate = apiModel?.releaseDate.orDefault(),
            charactersId = apiModel?.characters.orEmpty().map { idFromUrlManager.fromUrlToId(it) },
            planetsId = apiModel?.planets.orEmpty().map { idFromUrlManager.fromUrlToId(it) },
            starshipsId = apiModel?.starships.orEmpty().map { idFromUrlManager.fromUrlToId(it) },
            vehiclesId = apiModel?.vehicles.orEmpty().map { idFromUrlManager.fromUrlToId(it) },
            speciesId = apiModel?.species.orEmpty().map { idFromUrlManager.fromUrlToId(it) },
        )
    }
}