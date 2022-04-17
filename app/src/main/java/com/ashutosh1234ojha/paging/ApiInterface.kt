package com.ashutosh1234ojha.paging

import com.ashutosh1234ojha.paging.data.PhotoData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ashutosh Ojha on 05,January,2022
 */
interface ApiInterface {

    @GET("api/")
    suspend fun getPhoto(
        @Query("page") key: Int,
        @Query("key") value: String = "25117790-eec3f1b927790c6e3ea8614fa"
    ): Response<PhotoData>

    companion object {
        private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        fun getApi(): ApiInterface {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build();

            return Retrofit.Builder().baseUrl("https://pixabay.com").client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
                .create(ApiInterface::class.java)
        }

    }
}