package com.ashutosh1234ojha.mvvm.repository

import com.ashutosh1234ojha.mvvm.domain.model.Recipe

/**
 * Created by Ashutosh Ojha on 18,March,2022
 */
interface RecipeRepository {

    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun get(token: String, id: Int): Recipe

}