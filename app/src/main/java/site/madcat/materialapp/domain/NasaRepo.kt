package site.madcat.materialapp.domain

import site.madcat.materialapp.api.Epic
import site.madcat.materialapp.api.PictureOfTheDay

interface NasaRepo {
    suspend fun pictureOfTheDay(): PictureOfTheDay

    suspend fun getImageOfEpic(): Epic
}