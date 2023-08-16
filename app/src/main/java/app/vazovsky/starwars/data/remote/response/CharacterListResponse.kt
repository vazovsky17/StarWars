package app.vazovsky.starwars.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class CharacterListResponse(
    @SerializedName("count") val count: Long?,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<CharacterResponse>?,
) : Parcelable