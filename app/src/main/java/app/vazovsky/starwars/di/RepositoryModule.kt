package app.vazovsky.starwars.di

import app.vazovsky.starwars.data.repository.CharactersRepository
import app.vazovsky.starwars.data.repository.CharactersRepositoryImpl
import app.vazovsky.starwars.data.repository.FavoritesRepository
import app.vazovsky.starwars.data.repository.FavoritesRepositoryImpl
import app.vazovsky.starwars.data.repository.FilmsRepository
import app.vazovsky.starwars.data.repository.FilmsRepositoryImpl
import app.vazovsky.starwars.data.repository.StarshipsRepository
import app.vazovsky.starwars.data.repository.StarshipsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCharactersRepository(
        genresRepository: CharactersRepositoryImpl
    ): CharactersRepository

    @Binds
    abstract fun bindFavoritesRepository(
        genresRepository: FavoritesRepositoryImpl
    ): FavoritesRepository

    @Binds
    abstract fun bindStarshipsRepository(
        genresRepository: StarshipsRepositoryImpl
    ): StarshipsRepository

    @Binds
    abstract fun bindFilmsRepository(
        genresRepository: FilmsRepositoryImpl
    ): FilmsRepository
}