package com.example.mvvmlogin.domain.usuarios.models

class UsuarioList {
    companion object {
        var usuarios: MutableList<Usuario> = emptyList<Usuario>().toMutableList()
    }
}