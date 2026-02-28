package com.varun.loginappkotlin.di

import android.content.Context
import android.content.SharedPreferences
import com.varun.loginappkotlin.R
import com.varun.loginappkotlin.data.localprefs.UserPreferences
import com.varun.loginappkotlin.data.remote.Endpoints.BASEURL
import com.varun.loginappkotlin.data.remote.NetworkService
import com.varun.loginappkotlin.data.remote.Networking
import com.varun.loginappkotlin.data.repository.LoginRepository
import com.varun.loginappkotlin.data.repository.UserRepository
import com.varun.loginappkotlin.utils.network.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *
 *  Author : @Varun Kumar
 *
 * */

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {


    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(
            context.getString(R.string.app_name), Context.MODE_PRIVATE
        )

    @Provides
    @Singleton
    fun provideNetworkService(@ApplicationContext context: Context): NetworkService =
        Networking.createAPI(
            BASEURL, context.cacheDir, 10 * 1024 * 1024 // 10MB
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper =
        NetworkHelper(context)

    @Singleton
    @Provides
    fun loginRepository(networkService: NetworkService, userPreferences: UserPreferences): LoginRepository{
        return LoginRepository(networkService, userPreferences)
    }

    @Provides
    fun provideUserRepository(
        networkService: NetworkService, userPreferences: UserPreferences
    ): UserRepository {
        return UserRepository(networkService, userPreferences)
    }

}