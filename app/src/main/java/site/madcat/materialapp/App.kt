package site.madcat.materialapp

import android.app.Application
import android.content.Context

class App : Application() {
}

val Context.app
    get()=applicationContext as App