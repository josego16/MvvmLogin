package com.example.mvvmlogin.domain.users.models

import com.example.mvvmlogin.data.users.network.models.request.RequestLogin
import com.example.mvvmlogin.data.users.network.models.request.RequestRegister
import com.example.mvvmlogin.data.users.network.service.UserApiService
import com.example.mvvmlogin.frameworks.InstanceRetrofit
import javax.inject.Inject

class UserRepository @Inject constructor(private val service: UserApiService) {
    companion object {
        val repository: UserRepository by lazy {
            UserRepository(UserApiService(InstanceRetrofit.getApiService()))
        }
    }

    suspend fun loginApi(email: String, password: String): UserModel? {
        val userRequest = RequestLogin(email, password)
        val result = service.login(userRequest)

        result
            .onSuccess { resUser ->
                val user = UserModel(resUser.name, resUser.email, resUser.phone, "", resUser.token)
                return user
            }
            .onFailure {
                println("${it.message}")
            }
        return null
    }

    suspend fun register(user: UserModel): Boolean {
        val userRequest = RequestRegister(user.name, user.email, user.phone, user.password)
        val result = service.register(userRequest)
        result
            .onSuccess {
                return true
            }
            .onFailure {
                println("${it.message}")
            }
        return false
    }
}