package com.example.lesson5_2

import android.app.Application
import androidx.room.Room
import com.example.lesson5_2.model.room.AppDatabase

class App:Application() {
    companion object{
        lateinit var appDatabase: AppDatabase

    }
    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext,AppDatabase::class.java,"love-file").allowMainThreadQueries().build()
    }
}