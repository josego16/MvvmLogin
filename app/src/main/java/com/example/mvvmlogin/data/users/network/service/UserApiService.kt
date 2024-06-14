package com.example.mvvmlogin.data.users.network.service

import android.content.ContentValues.TAG
import android.util.Log
import com.example.mvvmlogin.data.users.network.models.request.RequestLogin
import com.example.mvvmlogin.data.users.network.models.request.RequestRegister
import com.example.mvvmlogin.data.users.network.models.response.ResponseLogin
import com.example.mvvmlogin.data.users.network.models.response.ResponseRegister
import javax.inject.Inject

class UserApiService @Inject constructor(val apiService: UserApiServiceInterface) {
    suspend fun login(user: RequestLogin): Result<ResponseLogin> {
        return try {
            Log.i(TAG, "login en user api: $user")
            val response = apiService.login(user)
            Log.i(TAG, "login respuesta del servidor : ${response.raw()} ")
            if (response.isSuccessful) {
                return response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(RuntimeException("Response body is null"))
            } else {
                Result.failure(RuntimeException("Response body is null"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun register(user: RequestRegister): Result<ResponseRegister> {
        return try {
            val response = apiService.register(user)
            Log.i(TAG, "register respuesta del servidor : ${response.body()} ")
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(RuntimeException("Response body is null"))
            } else {
                Result.failure(java.lang.RuntimeException("Response body is null"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}