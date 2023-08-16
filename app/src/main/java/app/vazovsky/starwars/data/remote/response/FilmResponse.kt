package app.vazovsky.starwars.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class FilmResponse(
    @SerializedName("title") val title: String?,
    @SerializedName("episode_id") val episodeId: Long?,
    @SerializedName("opening_crawl") val openingCrawl: String?,
    @SerializedName("director") val director: String?,
    @SerializedName("producer") val producer: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("characters") val characters: List<String>?,
    @SerializedName("planets") val planets: List<String>?,
    @SerializedName("starships") val starships: List<String>?,
    @SerializedName("vehicles") val vehicles: List<String>?,
    @SerializedName("species") val species: List<String>?,
    @SerializedName("url") val url: String?,
) : Parcelable