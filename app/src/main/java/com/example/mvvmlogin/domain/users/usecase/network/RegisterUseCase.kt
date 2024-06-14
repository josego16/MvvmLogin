package com.example.mvvmlogin.domain.users.usecase.network

import android.content.ContentValues.TAG
import android.util.Log
import com.example.mvvmlogin.domain.users.models.UserModel
import com.example.mvvmlogin.domain.users.models.UserRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend fun register(user: UserModel): Boolean {
        Log.i(TAG, "register: $user")
        return userRepository.register(user)
    }
}