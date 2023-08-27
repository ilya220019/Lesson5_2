package com.example.lesson5_2

import android.content.Context
import com.example.lesson5_2.model.LoveModel
import com.example.lesson5_2.model.RetrofitService
import com.example.lesson5_2.view.LoveView
import retrofit2.Call
import retrofit2.Response

class Presenter(val loveView: LoveView){
    var api = RetrofitService.api
    fun getLoveResult(firstName:String, secondName:String){

        api.calculateMatching(firstName,secondName

        ).enqueue(object:retrofit2.Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let { model-> loveView.navigationToResultScreen(model) }
            }
            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                loveView.showError(t.message.toString())
            }

        })
    }
}