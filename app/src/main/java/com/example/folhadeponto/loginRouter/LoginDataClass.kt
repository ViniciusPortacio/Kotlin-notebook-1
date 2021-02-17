package com.example.folhadeponto.loginRouter

import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("username")
    var username: String,
    @SerializedName("userPassword")
    var userPassword: String

)

data class ResponseBody(
    @SerializedName("StatusCode")
    var StatusCode: String
)