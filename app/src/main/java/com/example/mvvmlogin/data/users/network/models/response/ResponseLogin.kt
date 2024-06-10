package com.example.mvvmlogin.data.users.network.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseLogin(
    @SerializedName("result")
    @Expose
    val result: String = "",

    @SerializedName("token")
    @Expose
    val token: String = "",

    @SerializedName("id")
    @Expose
    val id: Int = 0,

    @SerializedName("nombre")
    @Expose
    val name: String = "",

    @SerializedName("email")
    @Expose
    val email: String = "",

    @SerializedName("imagen")
    @Expose
    val image: String = "",

    @SerializedName("details")
    @Expose
    var details: String = ""
)