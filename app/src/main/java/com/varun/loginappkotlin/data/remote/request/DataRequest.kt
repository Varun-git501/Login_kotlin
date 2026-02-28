package com.varun.loginappkotlin.data.remote.request

import com.google.gson.annotations.SerializedName

data class DataRequest(
    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("password")
    val password : String? = null,
)





