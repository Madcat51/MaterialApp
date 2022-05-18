package site.madcat.materialapp.domain

import site.madcat.materialapp.api.Epic
import site.madcat.materialapp.api.PhotoMars
import site.madcat.materialapp.api.PictureOfTheDay
import site.madcat.materialapp.api.ReturnPackage


interface NasaRepo {
    suspend fun pictureOfTheDay(day: String): PictureOfTheDay

    suspend fun getPhotoMars(soul: String): ReturnPackage

    suspend fun getImageOfEpic(): Epic

}