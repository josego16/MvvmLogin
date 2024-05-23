package com.example.mvvmlogin.domain.users

import com.example.mvvmlogin.data.users.entities.UserEntity
import com.example.mvvmlogin.domain.users.models.User

fun UserEntity.toDomain(): User? {
    this?.let {
        return User(this.name!!, this.password!!, this.email!!)
    }
    return null
}