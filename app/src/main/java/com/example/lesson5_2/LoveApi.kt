package com.example.lesson5_2



import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getData(): Call<LoveModel>
    @GET("getPercentage")
    fun calculateMatching(
        @Query("fname")firstName:String,
        @Query("sname")secondName:String,
        @Header("X-RapidAPI-Key") key:String = "005bf3c2abmsh72ba114ebb7da1dp1cc433jsn2fef6222f305",
        @Header("X-RapidAPI-Host") host:String = "love-calculator.p.rapidapi.com"
        ): Call<LoveModel>
}