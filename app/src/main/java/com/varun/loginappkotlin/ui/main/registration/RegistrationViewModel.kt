package com.varun.loginappkotlin.ui.main.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varun.loginappkotlin.data.remote.NetworkService
import com.varun.loginappkotlin.data.remote.response.RegistrationResponse
import com.varun.loginappkotlin.data.repository.RegistrationRepository
import com.varun.loginappkotlin.utils.common.Resource
import com.varun.loginappkotlin.utils.network.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val networkService: NetworkService,
    private val registrationRepository: RegistrationRepository,
) : ViewModel() {
    val loading: MutableLiveData<Boolean> = MutableLiveData()
//    private val xAuth = registrationRepository.getAccessToken()
//    private val xAuthId = registrationRepository.getId()
    val getRegistrationResponse: MutableLiveData<Resource<RegistrationResponse>> =
        MutableLiveData()
    private val messageString: MutableLiveData<Resource<String>> = MutableLiveData()

    fun getRegistration(email: String, password: String) {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                loading.postValue(true)

                val response = registrationRepository.registrationBody(email,password)
                if (response.isSuccessful) {
                    getRegistrationResponse.postValue(Resource.success(response.body()))
                    //registrationRepository.saveAccessToken(response.body()?.token.toString())
//                    response.body()?.id?.let { registrationRepository.setId(it.toInt() ) }
                } else {
                    messageString.postValue(Resource.error(response.body()?.token.toString()))
                }
                loading.postValue(false)
            }
        }
    }


}