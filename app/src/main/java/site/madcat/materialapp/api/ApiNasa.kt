package site.madcat.materialapp.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNasa {

    @GET("planetary/apod")
    suspend fun pictureOfTheDay(
        @Query("date") date: String,
        @Query("api_key") key: String
    ): PictureOfTheDay


    @GET("EPIC/api/natural")
    suspend fun getImageOfEpic(@Query("api_key") key: String): Epic

}


//https://api.nasa.gov/planetary/apod?date=2020-02-01&api_key=YUOR_KEY