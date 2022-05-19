package site.madcat.materialapp.domain

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import site.madcat.materialapp.api.ApiNasa

import site.madcat.materialapp.api.PictureOfTheDay


class NasaRepoImpl : NasaRepo {

    private val api=Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.nasa.gov/")
        .client(OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level=HttpLoggingInterceptor.Level.BODY
            })
        }
            .build()
        )
        .build()
        .create(ApiNasa::class.java)


    override suspend fun pictureOfTheDay(day: String): PictureOfTheDay=
        api.pictureOfTheDay(day, "wWBRoN1LSXiTHPye4LPg51NzWSeUmu0HOtd8yNmc")





}
//https://api.nasa.gov/planetary/apod?date=2022-05-06&api_key=wWBRoN1LSXiTHPye4LPg51NzWSeUmu0HOtd8yNmc