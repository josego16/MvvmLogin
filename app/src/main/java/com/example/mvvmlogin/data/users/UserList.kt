package com.example.mvvmlogin.data.users

import com.example.mvvmlogin.domain.users.models.Usuario

class UserList {
    companion object {
        var usuarios: MutableList<Usuario> = emptyList<Usuario>().toMutableList()
    }
}