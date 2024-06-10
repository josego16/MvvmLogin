package com.example.mvvmlogin.domain.users.usecase.network

import com.example.mvvmlogin.data.users.network.models.response.ResponseLogin
import com.example.mvvmlogin.data.users.network.models.response.ResponseRegister
import com.example.mvvmlogin.domain.users.models.UserModel

fun Result<ResponseLogin>.toDomain(): UserModel {
    if (this.isSuccess) {
        val user = this.getOrNull()!!
        if (user.image != null)
            return UserModel(user.name, "", user.email, user.token, "", user.image)
        else
            return UserModel(
                this.getOrNull()!!.name, "", "",
                this.getOrNull()!!.email,
                this.getOrNull()!!.token, ""
            )
    } else {
        return UserModel(this.exceptionOrNull()!!.message!!)
    }
}

fun Result<ResponseRegister>.toStringResponse(): String {
    if (this.isSuccess)
        return "Usuario añadido correctamente"
    else {
        return this.exceptionOrNull()!!.message!!
    }
}