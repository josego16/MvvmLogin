package com.example.mvvmlogin.data.users.network.service

import com.example.mvvmlogin.data.users.network.models.request.RequestLogin
import com.example.mvvmlogin.data.users.network.models.request.RequestRegister
import com.example.mvvmlogin.data.users.network.models.response.ResponseLogin
import com.example.mvvmlogin.data.users.network.models.response.ResponseRegister
import retrofit2.Response
import javax.inject.Inject

class UserApiService @Inject constructor(val apiService: UserApiServiceInterface) {
    suspend fun login(user: RequestLogin): Result<ResponseLogin> {
        try {
            val response: Response<ResponseLogin> = apiService.login(user)

            if (response.isSuccessful) {
                response.body()?.let { retUser ->
                    return Result.success(retUser)
                } ?: return Result.failure(Exception("Response body is null"))
            } else {
                return Result.failure(Exception(response.message()))
            }
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    suspend fun register(user: RequestRegister): Result<ResponseRegister> {
        try {
            val response: Response<ResponseRegister> = apiService.register(user)
            if (response.isSuccessful) {
                response.body()?.let {
                    return Result.success(it)
                } ?: return Result.failure(RuntimeException("Respuesta nula sin datos"))
            } else {
                return Result.failure(RuntimeException(response.message()))
            }
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}