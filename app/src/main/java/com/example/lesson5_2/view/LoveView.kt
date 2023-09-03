package com.example.lesson5_2.view

import com.example.lesson5_2.model.LoveModel
import java.lang.Error

interface LoveView {
    fun navigationToResultScreen(loveModel: LoveModel)
    fun navigationToOnBoarding()

    fun showError(error: String)
}