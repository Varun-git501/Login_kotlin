//package com.varun.loginappkotlin.ui.splash
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.varun.loginappkotlin.data.localprefs.UserPreferences
//import com.varun.loginappkotlin.data.repository.UserRepository
//import com.varun.loginappkotlin.utils.network.NetworkHelper
//import dagger.hilt.android.lifecycle.HiltViewModel
//import javax.inject.Inject
//
///**
// *
// *  Author : @Varun Kumar
// *
// * */
//@HiltViewModel
//class SplashViewModel @Inject constructor(
//    private val networkHelper: NetworkHelper,
//    private val userRepository: UserRepository
//) : ViewModel() {
//    private val loading: MutableLiveData<Boolean> = MutableLiveData()
//
//    fun addToken(token: String) {
//        if (networkHelper.isNetworkConnected()) {
//            loading.postValue(true)
//            userRepository.saveAccessToken(token)
//            loading.postValue(false)
//        }
//
//    }
//}