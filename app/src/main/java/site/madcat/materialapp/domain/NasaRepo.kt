package site.madcat.materialapp.domain

import site.madcat.materialapp.api.Epic
import site.madcat.materialapp.api.PictureOfTheDay
import java.sql.Date

interface NasaRepo {
    suspend fun pictureOfTheDay(): PictureOfTheDay
    suspend fun pictureOfBeforeDay(day: Date): PictureOfTheDay

    suspend fun getImageOfEpic(): Epic
}