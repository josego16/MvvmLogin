package com.example.mvvmlogin.data.users.network.service

import com.example.mvvmlogin.data.users.network.models.request.RequestLogin
import com.example.mvvmlogin.data.users.network.models.request.RequestRegister
import com.example.mvvmlogin.data.users.network.models.response.ResponseLogin
import com.example.mvvmlogin.data.users.network.models.response.ResponseRegister
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiServiceInterface {
    @POST("auth")
    suspend fun login(@Body loginUser: RequestLogin): Response<ResponseLogin>

    @POST("register")
    suspend fun register(@Body registerRequest: RequestRegister): Response<ResponseRegister>
}