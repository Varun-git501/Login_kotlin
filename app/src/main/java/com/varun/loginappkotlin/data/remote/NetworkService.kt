package com.varun.loginappkotlin.data.remote

import com.varun.loginappkotlin.data.remote.request.DataRequest
import com.varun.loginappkotlin.data.remote.response.LoginResponse
import com.varun.loginappkotlin.data.remote.response.RegistrationResponse
import com.varun.loginappkotlin.data.remote.response.UsersResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 *
 *  Author : @Varun Kumar
 *
 * */
interface NetworkService {
    //LOGIN REQUEST
    @Headers(
        "x-api-key: pub_e6f930df0e1a3dd57d1bf4563223c6f8f9f4d4ebd7da133e6aa082df5006ec51",
        "Content-Type: application/json"
    )
    @POST(Endpoints.LOGIN_URL)
    suspend fun login(
        @Body  dataRequest: DataRequest): Response<LoginResponse>

    //REGISTRATION REQUEST
    @Headers(
        "x-api-key: pub_e6f930df0e1a3dd57d1bf4563223c6f8f9f4d4ebd7da133e6aa082df5006ec51",
        "Content-Type: application/json"
    )
    @POST(Endpoints.REGISTER_URL)
    suspend fun register(
        @Body  registrationRequest: DataRequest): Response<RegistrationResponse>

    //USERS REQUEST
    @Headers(
        "x-api-key: pub_e6f930df0e1a3dd57d1bf4563223c6f8f9f4d4ebd7da133e6aa082df5006ec51",
        "Content-Type: application/json"
    )
    @GET(Endpoints.USERS_URL)
    suspend fun users(): Response<UsersResponse>

}
