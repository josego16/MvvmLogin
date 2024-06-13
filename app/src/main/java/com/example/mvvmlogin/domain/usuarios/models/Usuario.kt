package com.example.mvvmlogin.domain.usuarios.models

data class Usuario(
    var name: String,
    var email: String,
    var phone: String,
    var imagen: String
) {
    override fun toString(): String {
        return String.format("Nombre: %s\nEmail: %s\nTelefono: %s", name, email, phone)
    }
}