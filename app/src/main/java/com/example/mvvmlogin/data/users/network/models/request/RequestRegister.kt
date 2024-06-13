package com.example.mvvmlogin.data.users.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestRegister(
    @SerializedName("username")
    @Expose
    val username: String,

    @SerializedName("email")
    @Expose
    val email: String,

    @SerializedName("phone")
    @Expose
    val phone: String,

    @SerializedName("password")
    @Expose
    val password: String
) {
    @SerializedName("disponible")
    @Expose
    val disponible: String = "1"
}