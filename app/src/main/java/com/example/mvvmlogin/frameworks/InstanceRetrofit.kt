package com.example.mvvmlogin.frameworks

import com.example.mvvmlogin.data.users.network.service.UserApiServiceInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InstanceRetrofit {
    private const val URL_BASE_RETROFIT = "http://192.168.0.16/api-usuarios/endp/"

    private val retrofit: Retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl(URL_BASE_RETROFIT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val service: UserApiServiceInterface by lazy {
        retrofit.create(UserApiServiceInterface::class.java)
    }

    fun getApiService(): UserApiServiceInterface = service
}