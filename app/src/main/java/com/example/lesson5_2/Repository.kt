package com.example.lesson5_2

import com.example.lesson5_2.model.LoveApi
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi) {

}