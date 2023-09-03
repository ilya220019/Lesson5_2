package com.example.lesson5_2.module

import com.example.lesson5_2.Presenter
import com.example.lesson5_2.ui.FirstFragment
import com.example.lesson5_2.view.LoveView
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
abstract class InterfaceModule {
    @Binds
    abstract fun bindLoveView(fragment: FirstFragment   ): LoveView


}