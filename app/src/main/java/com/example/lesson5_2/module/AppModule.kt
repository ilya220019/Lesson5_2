package com.example.lesson5_2.module

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.lesson5_2.model.LoveApi
import com.example.lesson5_2.model.room.AppDatabase
import com.example.lesson5_2.model.room.LoveDao
import com.example.lesson5_2.preferens.Pref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule{
    @Inject
    lateinit var sharedPreferencesManager: Pref
    @Singleton
    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)

    }
    @Provides
    fun provide(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(context,AppDatabase::class.java,"love-file").allowMainThreadQueries().build()
    }
    @Provides
    fun provideLoveDao(appDatabase: AppDatabase):LoveDao{
        return appDatabase.loveDao()
    }
    @Provides
    fun providePref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("isOnboardingCompleted", Context.MODE_PRIVATE)
    }
}