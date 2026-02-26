package com.varun.loginappkotlin.data.remote.response

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    @field:SerializedName("token")
    val token: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

)
