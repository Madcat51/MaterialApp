package site.madcat.materialapp.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNasa {

    @GET("planetary/apod")
    suspend fun pictureOfTheDay(
        @Query("date") date: String,
        @Query("api_key") key: String
    ): PictureOfTheDay




    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun getImageOfMars(
        @Query("soul") string: String,
        @Query("api_key") key: String
    ): ReturnPackage

}
//https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=wWBRoN1LSXiTHPye4LPg51NzWSeUmu0HOtd8yNmc

//https://api.nasa.gov/planetary/apod?date=2020-02-01&api_key=YUOR_KEY
/*
https://api.nasa.gov/EPIC/api/natural/images?api_key=DEMO_KEY
https://api.nasa.gov/EPIC/api/natural/date/2019-05-30?api_key=DEMO_KEY
https://api.nasa.gov/EPIC/api/natural/all?api_key=DEMO_KEY
https://api.nasa.gov/EPIC/archive/natural/2019/05/30/png/epic_1b_20190530011359.png?api_key=DEMO_KEY*/
