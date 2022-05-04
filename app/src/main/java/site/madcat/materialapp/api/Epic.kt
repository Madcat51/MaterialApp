package site.madcat.materialapp.api

import com.google.gson.annotations.SerializedName
import java.util.*

data class Epic(
    @SerializedName("natural")
    val natural: String,

    @SerializedName("natural/date")
    val naturaldate:Date,

    @SerializedName("natural/all")
    val naturalall: String,

    @SerializedName("natural/available")
    val naturalavailable: String,

    @SerializedName("enhanced")
    val enhanced: String,

    @SerializedName("enhanced/date")
    val enhanceddate:Date,

    @SerializedName("enhanced/all")
    val enhancedall: String,

    @SerializedName("enhanced/available")
    val enhancedavailable: String,

)
