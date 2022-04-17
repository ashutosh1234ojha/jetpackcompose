package com.ashutosh1234ojha.mvvm.di

import com.ashutosh1234ojha.mvvm.network.RecipeService
import com.ashutosh1234ojha.mvvm.network.model.RecipeDtoMapper
import com.ashutosh1234ojha.mvvm.repository.RecipeRepository
import com.ashutosh1234ojha.mvvm.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Ashutosh Ojha on 18,March,2022
 */
@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeMapper: RecipeDtoMapper,
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService = recipeService,
            mapper = recipeMapper
        )
    }
}