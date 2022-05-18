package site.madcat.materialapp.api

import com.google.gson.annotations.SerializedName
import java.util.*

data class Epic(
    @SerializedName("image")
    val image: String,

    @SerializedName("date")
    val date: Date,
    @SerializedName("caption")
    val Caption: String
    )
