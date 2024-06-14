package com.example.mvvmlogin.domain.usuarios.models

import com.example.mvvmlogin.domain.users.models.UserModel
import javax.inject.Inject

class Profile @Inject constructor() {
    lateinit var user: UserModel

    companion object {
        val profile: Profile by lazy {
            Profile()
        }
    }
}