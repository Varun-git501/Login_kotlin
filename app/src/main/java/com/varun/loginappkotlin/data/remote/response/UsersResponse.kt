package com.varun.loginappkotlin.data.remote.response

import com.google.gson.annotations.SerializedName


data class UsersResponse(
    @field:SerializedName("per_page")
    val perpage: Int? = 0,

    @field:SerializedName("data")
    val list: List<DataList?>? = emptyList(),

    @field:SerializedName("total")
    val total: Int? = 0,

    @field:SerializedName("page")
    val page: Int? = 0,

    @field:SerializedName("total_pages")
    val totalpages: Int? = 0
    )



