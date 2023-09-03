package com.example.lesson5_2

import com.example.lesson5_2.model.LoveApi
import com.example.lesson5_2.model.LoveModel
import com.example.lesson5_2.preferens.Pref
import com.example.lesson5_2.view.LoveView
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class Presenter @Inject constructor(private val api: LoveApi) {
    lateinit var loveView: LoveView
    @Inject
    lateinit var pref: Pref

    fun getLoveResult(firstName: String, secondName: String) {
        api.calculateMatching(
            firstName, secondName
        ).enqueue(object : retrofit2.Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let { model -> loveView.navigationToResultScreen(model) }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                loveView.showError(t.message.toString())
            }

        })
    }
    fun showOnBoarding(){
        if (!pref.isOnboardingShowed()){
            loveView.navigationToOnBoarding()
        }
    }
    fun attachView(view: LoveView){
        this.loveView = view
    }
}