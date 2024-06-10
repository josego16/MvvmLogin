package com.example.mvvmlogin.domain.users.models

class UserModel(
    val name: String,
    val password: String,
    val confirmPassword: String,
    val email: String,
    val token: String,
    val details: String,
    val imagen: String?
) {
    // Constructor para detalles
    constructor(details: String) : this(
        name = "",
        password = "",
        confirmPassword = "",
        email = "",
        token = "",
        details,
        imagen = ""
    )

    // Constructor para usuario sin imagen
    constructor(
        name: String,
        password: String,
        confirmPassword: String,
        email: String,
        token: String,
        details: String
    ) : this(
        name,
        password,
        confirmPassword,
        email,
        token,
        details,
        imagen = null
    )

    // Constructor para registro
    constructor(name: String, password: String, email: String, confirmPassword: String) : this(
        name,
        password,
        confirmPassword,
        email,
        token = "",
        details = "",
        imagen = null
    )

    // Constructor para login
    constructor(name: String, password: String) : this(
        name,
        password,
        confirmPassword = "",
        email = "",
        token = "",
        details = "",
        imagen = ""
    )
}