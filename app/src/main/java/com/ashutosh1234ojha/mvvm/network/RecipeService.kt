package com.ashutosh1234ojha.mvvm.network

import com.ashutosh1234ojha.mvvm.network.model.RecipeDto
import com.ashutosh1234ojha.mvvm.network.response.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created by Ashutosh Ojha on 18,March,2022
 */
interface RecipeService {

    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): RecipeSearchResponse

    @GET("get")
    suspend fun get(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): RecipeDto
}
