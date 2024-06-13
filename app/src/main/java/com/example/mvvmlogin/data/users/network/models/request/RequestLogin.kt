package com.example.mvvmlogin.data.users.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestLogin(
    @SerializedName("username")
    @Expose
    var username: String,
    @SerializedName("password")
    @Expose
    var password: String
) {}