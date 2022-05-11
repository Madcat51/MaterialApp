package site.madcat.materialapp

import android.app.Application
import android.content.Context
import site.madcat.materialapp.domain.NasaRepoImpl

class App : Application() {

    val repo=NasaRepoImpl()

}

val Context.app
    get()=applicationContext as App