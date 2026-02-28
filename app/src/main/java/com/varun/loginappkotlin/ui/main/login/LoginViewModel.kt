package com.varun.loginappkotlin.ui.main.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varun.loginappkotlin.data.remote.NetworkService
import com.varun.loginappkotlin.data.remote.response.LoginResponse
import com.varun.loginappkotlin.data.repository.LoginRepository
import com.varun.loginappkotlin.utils.common.Resource
import com.varun.loginappkotlin.utils.network.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val networkService: NetworkService,
    private val loginRepository: LoginRepository,
) : ViewModel() {
    val loading: MutableLiveData<Boolean> = MutableLiveData()
    private val xAuth = loginRepository.getAccessToken()
    val getloginResponse: MutableLiveData<Resource<LoginResponse>> =
        MutableLiveData()
    private val messageString: MutableLiveData<Resource<String>> = MutableLiveData()

    fun getLogin(email: String, password: String) {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                loading.postValue(true)

                val response = loginRepository.loginBody(email,password)
                if (response.isSuccessful) {
                    getloginResponse.postValue(Resource.success(response.body()))
                    loginRepository.saveAccessToken(response.body()?.token.toString())
                } else {
                    messageString.postValue(Resource.error(response.body()?.token.toString()))
                }
                loading.postValue(false)
            }
        }
    }


}