package com.ashutosh1234ojha.download

import retrofit2.Retrofit

/**
 * Created by Ashutosh Ojha on 26,March,2022
 */
object RetrofitClient {

    fun getClient(): FileApi = Retrofit.Builder()
        .baseUrl("https://pl-coding.com/")
        .build()
        .create(FileApi::class.java)

}