package site.madcat.materialapp

import android.app.Application
import android.content.Context
import site.madcat.materialapp.data.LocalRepo

class App : Application() {
    val localRepository=LocalRepo()
}

val Context.app
    get()=applicationContext as App