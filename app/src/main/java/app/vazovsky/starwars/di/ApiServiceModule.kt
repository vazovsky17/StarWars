package app.vazovsky.starwars.di

import android.content.Context
import app.vazovsky.starwars.data.remote.MockStarWarsApiService
import app.vazovsky.starwars.data.remote.SemimockStarWarsApiService
import app.vazovsky.starwars.data.remote.StarWarsApiService
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://swapi.dev/api/"

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {
    @Singleton
    @Provides
    fun provideClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(ChuckerInterceptor(context)).build()
    }


    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).client(client).build()
    }

    @Singleton
    @Provides
    fun provideApiService(
        retrofit: Retrofit,
    ): StarWarsApiService {
        return SemimockStarWarsApiService(
            apiService = retrofit.create(StarWarsApiService::class.java),
            mockApiService = MockStarWarsApiService(),
        )
    }
}