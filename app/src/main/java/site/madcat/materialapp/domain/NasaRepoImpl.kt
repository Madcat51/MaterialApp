package site.madcat.materialapp.domain

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import site.madcat.materialapp.api.ApiNasa
import site.madcat.materialapp.api.Epic
import site.madcat.materialapp.api.PictureOfTheDay


 class NasaRepoImpl:NasaRepo {

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


    override suspend fun pictureOfTheDay(): PictureOfTheDay=
        api.pictureOfTheDay("wWBRoN1LSXiTHPye4LPg51NzWSeUmu0HOtd8yNmc")

     override suspend fun getImageOfEpic(): Epic=
         api.getImageOfEpic("wWBRoN1LSXiTHPye4LPg51NzWSeUmu0HOtd8yNmc")



 }