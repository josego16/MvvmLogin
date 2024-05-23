package com.example.mvvmlogin.data.users.objects

import com.example.mvvmlogin.domain.users.models.Usuario

object RepositoryUsers {
    val usuarioList: List<Usuario> = listOf(
        Usuario(
            0,
            "jose maria",
            "josemagomez53@gmail.com",
            "654 23 45 67",
            "https://img.freepik.com/free-vector/illustration-businessman_53876-5856.jpg"
        ),
        Usuario(
            1,
            "jose pedro",
            "josepedro@gmail.com",
            "664 23 54 27",
            "https://img.freepik.com/free-vector/illustration-businessman_53876-5856.jpg"
        ),
        Usuario(
            2,
            "jose pablo",
            "josepablo@gmail.com",
            "674 24 21 80",
            "https://img.freepik.com/free-vector/illustration-businessman_53876-5856.jpg"
        ),
        Usuario(
            3,
            "jose antonio",
            "joseantonio@gmail.com",
            "632 10 32 90",
            "https://img.freepik.com/free-vector/illustration-businessman_53876-5856.jpg"
        ),
        Usuario(
            4,
            "jose luis",
            "joseluis@gmail.com",
            "610 65 75 99",
            "https://img.freepik.com/free-vector/illustration-businessman_53876-5856.jpg"
        ),
    )
}