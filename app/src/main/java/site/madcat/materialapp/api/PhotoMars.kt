package site.madcat.materialapp.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class ReturnPackage(
    @SerializedName("Photos")
    val photos: List<PhotoMars>
)

data class PhotoMars(
    @SerializedName("img_src")
    val image: String,
    @SerializedName("date")
    val date: Date
) : Serializable {


}
