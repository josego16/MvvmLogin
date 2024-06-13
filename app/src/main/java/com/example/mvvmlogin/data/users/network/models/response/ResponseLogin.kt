package com.example.mvvmlogin.data.users.network.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseLogin {
    @SerializedName("result")
    @Expose
    val result: String = ""

    @SerializedName("token")
    @Expose
    val token: String = ""

    @SerializedName("id")
    @Expose
    val id: Int = 0

    @SerializedName("username")
    @Expose
    val username: String = ""

    @SerializedName("email")
    @Expose
    val email: String = ""

    @SerializedName("phone")
    @Expose
    val phone: String = ""

    @SerializedName("password")
    @Expose
    val password: String = ""

    @SerializedName("imagen")
    @Expose
    val imagen: String = ""

    @SerializedName("details")
    @Expose
    var details: String = ""
}