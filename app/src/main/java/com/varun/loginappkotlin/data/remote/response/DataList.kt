package com.varun.loginappkotlin.data.remote.response

import com.google.gson.annotations.SerializedName

data class DataList(
    @field:SerializedName("id")
    val id: Int? = 0,

    @field:SerializedName("last_name")
    val lastname: String? = "",

    @field:SerializedName("avatar")
    val avatar: String? = "",

    @field:SerializedName("first_name")
    val firstname: String? = "",

    @field:SerializedName("email")
    val email: String? = "",
)
