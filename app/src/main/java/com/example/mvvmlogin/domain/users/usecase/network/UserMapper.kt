package com.example.mvvmlogin.domain.users.usecase.network

import com.example.mvvmlogin.data.users.network.models.response.ResponseLogin
import com.example.mvvmlogin.data.users.network.models.response.ResponseRegister
import com.example.mvvmlogin.domain.users.models.UserModel

fun Result<ResponseLogin>.toDomain(): UserModel {
    return if (this.isSuccess)
        UserModel("", "", "", "", "", "")
    else {
        UserModel(this.exceptionOrNull()!!.message!!)
    }
}

fun Result<ResponseRegister>.toStringResponse(): String {
    return if (this.isSuccess)
        "Usuario añadido correctamente"
    else
        this.exceptionOrNull()!!.message!!
}