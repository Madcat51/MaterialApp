package site.madcat.materialapp.domain

import site.madcat.materialapp.api.PhotoMars
import java.io.Serializable

interface LocalRepoInterfase : Serializable{
    val photoFromTheRover: List<PhotoMars?>?
    fun addPhoto(photoFromTheRover: PhotoMars?)
    fun clear()
}