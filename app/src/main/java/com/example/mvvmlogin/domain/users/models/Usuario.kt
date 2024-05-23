package com.example.mvvmlogin.domain.users.models

data class Usuario(
    var id: Int,
    var name: String,
    var email: String,
    var phone: String,
    var imagen: String
) {
    override fun toString(): String {
        return String.format("Nombre: %s\nEmail: %s\nTelefono: %s", name, email, phone)
    }
}