package com.varun.loginappkotlin.data.repository

import com.varun.loginappkotlin.data.localprefs.UserPreferences
import com.varun.loginappkotlin.data.remote.NetworkService
import com.varun.loginappkotlin.data.remote.request.DataRequest
import com.varun.loginappkotlin.data.remote.response.LoginResponse
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val networkService: NetworkService,  private val userPreferences: UserPreferences
) {
    fun getAccessToken(): String? {
        return userPreferences.getAccessToken()
    }

    fun saveAccessToken(token: String) {
        userPreferences.setAccessToken(token)
    }

    //login body
    suspend fun loginBody(
        email: String, password: String
    ): Response<LoginResponse> {
        return networkService.login(
            DataRequest(email,password)
        )
    }
}
