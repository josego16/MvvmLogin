package com.example.mvvmlogin.domain.users

import com.example.mvvmlogin.data.users.entities.UserEntity
import com.example.mvvmlogin.domain.users.models.UserModel

fun UserEntity.toDomain(): UserModel? {
    this?.let {
        return UserModel(this.name!!, this.password!!,this.confirmPassword!!, this.email!!)
    }
    return null
}