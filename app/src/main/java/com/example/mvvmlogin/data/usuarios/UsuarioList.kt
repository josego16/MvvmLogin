package com.example.mvvmlogin.data.usuarios

import com.example.mvvmlogin.data.usuarios.entities.Usuario

class UsuarioList {
    companion object {
        var usuarios: MutableList<Usuario> = emptyList<Usuario>().toMutableList()
    }
}