package com.ashutosh1234ojha.mvvm.repository

import com.ashutosh1234ojha.mvvm.domain.model.Recipe
import com.ashutosh1234ojha.mvvm.network.RecipeService
import com.ashutosh1234ojha.mvvm.network.model.RecipeDtoMapper

/**
 * Created by Ashutosh Ojha on 18,March,2022
 */
class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
) :
    RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        val recipeList = recipeService.search(token, page, query)
        return mapper.toDomainList(recipeList.recipes)

    }

    override suspend fun get(token: String, id: Int): Recipe {
        val recipe = recipeService.get(token, id)
        return mapper.mapToDomainModel(recipe)
    }
}