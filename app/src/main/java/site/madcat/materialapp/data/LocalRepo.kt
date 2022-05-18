package site.madcat.materialapp.data

import site.madcat.materialapp.api.PhotoMars
import site.madcat.materialapp.domain.LocalRepoInterfase


class LocalRepo : LocalRepoInterfase {
    var cash:ArrayList<PhotoMars> =ArrayList<PhotoMars>()

    override val photoFromTheRover: List<PhotoMars?>?
        get()=ArrayList(cash)

    override fun addPhoto(photoFromTheRover: PhotoMars?) {
        cash.add(photoFromTheRover!!)
    }

    override fun clear() {
        cash.clear()
    }
}