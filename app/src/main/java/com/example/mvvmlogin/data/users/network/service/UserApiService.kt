package com.example.mvvmlogin.data.users.network.service

import android.content.ContentValues.TAG
import android.util.Log
import com.example.mvvmlogin.data.users.network.models.request.RequestLogin
import com.example.mvvmlogin.data.users.network.models.request.RequestRegister
import com.example.mvvmlogin.data.users.network.models.response.ResponseLogin
import com.example.mvvmlogin.data.users.network.models.response.ResponseRegister
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class UserApiService @Inject constructor(val apiService: UserApiServiceInterface) {
    suspend fun login(user: RequestLogin): Result<ResponseLogin> {
        try {
            Log.i(TAG, "login en user api: $user")
            val response: Response<ResponseLogin> = apiService.login(user)
            Log.i(TAG, "login respuesta del servidor : ${response.raw()} ")
            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body()!!)
            } else {
                val errorBody = response.errorBody()
                if (errorBody != null) {
                    val jsonObj = JSONObject(errorBody.charStream().readText())
                    return Result.failure(java.lang.RuntimeException(jsonObj.getString("details")))
                } else {
                    return Result.failure(java.lang.RuntimeException("Response body is null"))
                }
            }
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    suspend fun register(user: RequestRegister): Result<ResponseRegister> {
        try {
            val response: Response<ResponseRegister> = apiService.register(user)
            Log.i(TAG, "register respuesta del servidor : ${response.body()} ")
            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body()!!)
            } else {
                val errorBody = response.errorBody()
                if (errorBody != null) {
                    val jsonObj = JSONObject(errorBody.charStream().readText())
                    return Result.failure(java.lang.RuntimeException(jsonObj.getString("details")))
                } else {
                    return Result.failure(java.lang.RuntimeException("Response body is null"))
                }
            }
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}