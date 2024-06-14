package com.example.mvvmlogin.domain.users.models

class UserModel(
    val name: String,
    val email: String,
    val phone: String,
    val password: String,
    val imagen: String,
    val token: String = ""
) {
    constructor(disponible: String) : this(
        name = "",
        email = "",
        phone = "",
        password = "",
        imagen = "",
        token = ""
    )

    constructor(name: String, email: String, phone: String, password: String) : this(
        name,
        phone,
        email,
        password,
        imagen = "",
        token = ""
    )

    constructor(email: String, password: String) : this(
        "",
        email,
        "",
        password,
        imagen = "",
        token = "",
    )
}