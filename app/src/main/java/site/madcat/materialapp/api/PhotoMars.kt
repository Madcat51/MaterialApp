package site.madcat.materialapp.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class ReturnPackagePhoto(
    @SerializedName("photos")
    val photos: List<PhotoMars>,
) : Serializable

data class PhotoMars(
    @SerializedName("img_src")
    val image: String,
    @SerializedName("earth_date")
    val date: Date
) : Serializable {


}
