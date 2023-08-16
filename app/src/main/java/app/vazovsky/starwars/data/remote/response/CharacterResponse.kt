package app.vazovsky.starwars.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class CharacterResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("height") val height: String?,
    @SerializedName("mass") val mass: String?,
    @SerializedName("hair_color") val hairColor: String?,
    @SerializedName("skin_color") val skinColor: String?,
    @SerializedName("eye_color") val eyeColor: String?,
    @SerializedName("birth_year") val birthYear: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("homeworld") val homeworld: String?,
    @SerializedName("films") val filmsUrl: List<String>,
    @SerializedName("species") val species: List<String>,
    @SerializedName("vehicles") val vehicles: List<String>,
    @SerializedName("starships") val starships: List<String>,
    @SerializedName("url") val url: String,
) : Parcelable