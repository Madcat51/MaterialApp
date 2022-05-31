package site.madcat.materialapp.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNasa {

    @GET("planetary/apod")
    suspend fun pictureOfTheDay(
        @Query("date") date: String,
        @Query("api_key") key: String
    ): PictureOfTheDay


    @GET("mars-photos/api/v1/rovers/curiosity/photos?page=1")
    suspend fun getImageOfMars(
        @Query("api_key") string: String,
        @Query("earth_date") earthDate: String
    ): ReturnPackagePhoto

}
