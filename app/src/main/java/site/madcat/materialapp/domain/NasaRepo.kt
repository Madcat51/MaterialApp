package site.madcat.materialapp.domain



import site.madcat.materialapp.api.PictureOfTheDay



interface NasaRepo {
    suspend fun pictureOfTheDay(day: String): PictureOfTheDay




}