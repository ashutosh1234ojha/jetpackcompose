package com.ashutosh1234ojha.mvvm.di

import android.content.Context
import com.ashutosh1234ojha.mvvm.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by Ashutosh Ojha on 18,March,2022
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }
}