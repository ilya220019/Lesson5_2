package com.example.lesson5_2.preferens

import android.content.SharedPreferences
import javax.inject.Inject

class Pref @Inject
constructor(private val preferences: SharedPreferences) {


    fun isOnboardingShowed(): Boolean {
        return preferences.getBoolean("isOnboardingCompleted", false)
    }

    fun onBoardingShowed() {
        preferences.edit().putBoolean("isOnboardingCompleted", true).apply()
    }
}
