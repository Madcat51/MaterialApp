package site.madcat.materialapp.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNasa {

    @GET("planetary/apod")
    suspend fun pictureOfTheDay(@Query("api_key") key: String): PictureOfTheDay

    @GET("EPIC/api/natural")
    suspend fun getImageOfEpic(@Query("api_key") key: String): Epic

}