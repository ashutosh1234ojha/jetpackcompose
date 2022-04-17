package com.ashutosh1234ojha.download

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Ashutosh Ojha on 26,March,2022
 */
interface FileApi {

    @GET("/wp-content/uploads/2022/02/220849-scaled.jpg")
    suspend fun downloadImage(): Response<ResponseBody>
}