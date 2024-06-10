package com.example.mvvmlogin.domain.users.usecase.network

import com.example.mvvmlogin.data.users.network.models.request.RequestRegister
import com.example.mvvmlogin.data.users.network.service.UserApiService
import com.example.mvvmlogin.domain.users.models.UserModel
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val contactsService: UserApiService
) {
    suspend operator fun invoke(user: UserModel): String {
        return contactsService.register(
            RequestRegister(
                user.email,
                user.name,
                user.password,
                user.imagen
            )
        ).toStringResponse()
    }
}