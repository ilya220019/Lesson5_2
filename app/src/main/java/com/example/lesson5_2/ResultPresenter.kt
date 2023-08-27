package com.example.lesson5_2

import com.example.lesson5_2.model.LoveModel
import com.example.lesson5_2.view.ResultView

class ResultPresenter(private val resultView: ResultView) {

    fun getData(loveModel: LoveModel){
        resultView.showLove(loveModel.firstName,loveModel.secondName,loveModel.percentage,loveModel.result)
    }

}