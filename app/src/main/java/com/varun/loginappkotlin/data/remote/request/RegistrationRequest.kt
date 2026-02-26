package com.varun.loginappkotlin.data.remote.request

import com.google.gson.annotations.SerializedName

data class RegistrationRequest(
        @field:SerializedName("email")
        val email: String? = null,

        @field:SerializedName("password")
        val password : String? = null,

//        @field:SerializedName("firstname")
//        val firstname : String? = null,
//
//        @field:SerializedName("lastname")
//        val lastname : String? = null
)
