package com.varun.loginappkotlin.data.remote.response

import com.google.gson.annotations.SerializedName


data class LoginResponse(
    @field:SerializedName("token")
    val token: String? = null


//
//    @field:SerializedName("data")
//    val list: List<DataList?>? = emptyList()
)