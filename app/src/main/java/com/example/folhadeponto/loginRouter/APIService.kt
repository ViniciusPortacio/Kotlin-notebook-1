package com.example.folhadeponto.loginRouter

import com.example.folhadeponto.apiConfig.RetrofitClient
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @Headers("Content-Type: application/json; charset=utf-8")
    @POST("entrar")
    fun postLogin( @Body body: LoginData ): Call<ResponseBody>


    // Abstrair esse objeto em um futuro refactor
    object ApiUtils {
        val BASE_URL = "http://192.168.1.182:3004/api/v1/"
        val apiService: APIService
            get() = RetrofitClient.RetrofitClient.getClient(BASE_URL)!!.create(APIService::class.java)

    }
}