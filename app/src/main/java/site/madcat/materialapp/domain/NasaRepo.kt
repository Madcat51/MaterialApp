package site.madcat.materialapp.domain


import site.madcat.materialapp.api.PictureOfTheDay
import site.madcat.materialapp.api.ReturnPackagePhoto


interface NasaRepo {
    suspend fun pictureOfTheDay(day: String): PictureOfTheDay
    suspend fun photoMars(day: String): ReturnPackagePhoto
}