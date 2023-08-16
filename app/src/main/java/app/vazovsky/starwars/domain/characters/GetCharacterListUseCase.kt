package app.vazovsky.starwars.domain.characters

import androidx.paging.PagingData
import app.vazovsky.starwars.data.model.Character
import app.vazovsky.starwars.data.repository.CharactersRepository
import app.vazovsky.starwars.domain.base.paging.createPager
import app.vazovsky.starwars.domain.base.usecase.UseCasePaged
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow


class GetCharacterListUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository,
) : UseCasePaged<GetCharacterListUseCase.Params, Character>() {

    override fun execute(params: Params): Flow<PagingData<Character>> {
        return createPager(
            pagingSource = CharacterPagingSource(
                query = params.search,
                charactersRepository = charactersRepository,
            )
        ).flow
    }

    data class Params(
        val search: String? = null,
    )
}