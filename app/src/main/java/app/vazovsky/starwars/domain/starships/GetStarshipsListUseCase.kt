package app.vazovsky.starwars.domain.starships

import androidx.paging.PagingData
import app.vazovsky.starwars.data.model.Starship
import app.vazovsky.starwars.data.repository.StarshipsRepository
import app.vazovsky.starwars.domain.base.paging.createPager
import app.vazovsky.starwars.domain.base.usecase.UseCasePaged
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetStarshipsListUseCase @Inject constructor(
    private val starshipsRepository: StarshipsRepository,
) : UseCasePaged<GetStarshipsListUseCase.Params, Starship>() {

    override fun execute(params: Params): Flow<PagingData<Starship>> {
        return createPager(
            pagingSource = StarshipsPagingSource(
                query = params.search,
                starshipsRepository = starshipsRepository,
            )
        ).flow
    }

    data class Params(
        val search: String? = null,
    )
}