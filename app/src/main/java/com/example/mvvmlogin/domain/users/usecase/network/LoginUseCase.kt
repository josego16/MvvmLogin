package com.example.mvvmlogin.domain.users.usecase.network

import android.content.ContentValues.TAG
import android.util.Log
import com.example.mvvmlogin.domain.users.models.UserModel
import com.example.mvvmlogin.domain.users.models.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun login(email: String, password: String): UserModel? {
        Log.i(TAG, "login: $email $password")
        return userRepository.loginApi(email, password)
    }
}