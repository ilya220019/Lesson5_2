package com.example.lesson5_2.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lesson5_2.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

   abstract fun loveDao(): LoveDao

}