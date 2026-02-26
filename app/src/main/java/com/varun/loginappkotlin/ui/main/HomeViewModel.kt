package com.varun.loginappkotlin.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varun.loginappkotlin.data.remote.response.LoginResponse
import com.varun.loginappkotlin.data.remote.response.UsersResponse
import com.varun.loginappkotlin.data.repository.UserRepository
import com.varun.loginappkotlin.utils.common.Resource
import com.varun.loginappkotlin.utils.common.Toaster
import com.varun.loginappkotlin.utils.network.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 *  Author : @Varun Kumar
 *
 * */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val userRepository: UserRepository,
) : ViewModel() {
    val loading: MutableLiveData<Boolean> = MutableLiveData()
    private val xAuth = userRepository.getAccessToken()
    public val getloginResponse: MutableLiveData<Resource<UsersResponse>> =
        MutableLiveData()
    private val messageString: MutableLiveData<Resource<String>> = MutableLiveData()

    fun getCurrentMatches() {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                loading.postValue(true)

                val response = userRepository.getAllUsers()
                if (response.isSuccessful) {
//                    Toaster.show(context , response.body().toString())
                    getloginResponse.postValue(Resource.success(response.body()))
                } else {
                    messageString.postValue(Resource.error(response.body().toString()))
                }
                loading.postValue(false)
            }
        }
    }
}