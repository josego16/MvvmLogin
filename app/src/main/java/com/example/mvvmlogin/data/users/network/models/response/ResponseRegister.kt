package com.example.mvvmlogin.data.users.network.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseRegister() {
    @SerializedName("result")
    @Expose
    var result: String = ""

    @SerializedName("insert_id")
    @Expose
    var insertId: String = ""

    @SerializedName("details")
    @Expose
    var details: String = ""
}