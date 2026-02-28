package com.varun.loginappkotlin.data.repository

import com.varun.loginappkotlin.data.localprefs.UserPreferences
import com.varun.loginappkotlin.data.remote.NetworkService
import com.varun.loginappkotlin.data.remote.request.DataRequest
import com.varun.loginappkotlin.data.remote.response.RegistrationResponse
import retrofit2.Response
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val networkService: NetworkService,  private val userPreferences: UserPreferences
) {
//    fun getAccessToken(): String? {
//        return userPreferences.getAccessToken()
//    }
//
//    fun saveAccessToken(token: String) {
//        userPreferences.setAccessToken(token)
//    }
//
//    fun setId(id: Int) {
//        userPreferences.setId(id)
//    }
//
//    fun getId(): Int {
//        return userPreferences.getId()
//    }

    //Registration body
    suspend fun registrationBody(
        email: String, password: String
    ): Response<RegistrationResponse> {
        return networkService.register(
            DataRequest(email,password)
        )
    }
}
