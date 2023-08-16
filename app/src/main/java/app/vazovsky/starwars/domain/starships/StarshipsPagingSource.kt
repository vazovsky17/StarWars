package app.vazovsky.starwars.domain.starships

import app.vazovsky.starwars.data.model.Starship
import app.vazovsky.starwars.data.repository.StarshipsRepository
import app.vazovsky.starwars.domain.base.paging.BasePagingSource

class StarshipsPagingSource(
    query: String?,
    private val starshipsRepository: StarshipsRepository,
) : BasePagingSource<Starship>(query) {
    override suspend fun loadPage(offset: Int, limit: Int, query: String?): List<Starship> {
        return starshipsRepository.getStarships(page = offset).starships
    }
}