package com.varun.loginappkotlin.data.repository

import com.varun.loginappkotlin.data.localprefs.UserPreferences
import com.varun.loginappkotlin.data.remote.NetworkService
import com.varun.loginappkotlin.data.remote.response.LoginResponse
import com.varun.loginappkotlin.data.remote.response.UsersResponse
import retrofit2.Response
import javax.inject.Inject

/**
 *
 *  Author : @Varun Kumar
 *
 * */

class UserRepository @Inject constructor(
    private val networkService: NetworkService, private val userPreferences: UserPreferences
) {

//    fun saveAccessToken(token: String) {
//        userPreferences.setAccessToken(token)
//    }
//
//    fun getAccessToken(): String? {
//        return userPreferences.getAccessToken()
//    }

    suspend fun getAllUsers(): Response<UsersResponse> {
        return networkService.users()
    }

}