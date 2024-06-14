package com.example.mvvmlogin.data.users.network.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseRegister(
    @SerializedName("result")
    @Expose
    val result: String,

    @SerializedName("id")
    @Expose
    val id: Int
)