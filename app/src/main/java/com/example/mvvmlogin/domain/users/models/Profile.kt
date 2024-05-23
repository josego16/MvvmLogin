package com.example.mvvmlogin.domain.users.models

class Profile private constructor(){

    lateinit var usuario : Usuario //Tengo aquí el usuario logueado
    companion object{
        val profile: Profile by lazy {
            Profile()  //creo el objeto singleton
        }
    }


    fun setUser (profileUsuario : Usuario){
        usuario = profileUsuario
    }
}