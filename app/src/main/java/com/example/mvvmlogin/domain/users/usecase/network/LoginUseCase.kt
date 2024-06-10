package com.example.mvvmlogin.domain.users.usecase.network

import com.example.mvvmlogin.data.users.network.models.request.RequestLogin
import com.example.mvvmlogin.data.users.network.service.UserApiService
import com.example.mvvmlogin.domain.users.models.UserModel
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val contactsService: UserApiService
){
    suspend operator fun invoke(username: String, password: String) : UserModel {
        return contactsService.login(RequestLogin(username, password)).toDomain()
    }
}