package com.example.mvvmlogin.domain.users.models

class UserModel(
    val username: String,
    val email: String,
    val phone: String,
    val password: String,
    val token: String,
    val disponible: String
) {
    constructor(disponible: String) : this(
        username = "",
        email = "",
        phone = "",
        password = "",
        token = "",
        disponible
    )

    constructor(username: String, email: String, phone: String, password: String) : this(
        username,
        phone,
        email,
        password,
        token = "",
        disponible = "true"
    )

    constructor(username: String, password: String) : this(
        username,
        "",
        "",
        password,
        token = "",
        disponible = ""
    )
}