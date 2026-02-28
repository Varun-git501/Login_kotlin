package com.varun.loginappkotlin.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle

import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.varun.loginappkotlin.databinding.ActivitySplashBinding
import com.varun.loginappkotlin.ui.main.login.LoginActivity
import com.varun.loginappkotlin.ui.main.homepage.RecyclerViewHomeActivity
//import com.varun.loginappkotlin.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 *  Author : @Varun Kumar
 *
 * */
@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private val displayLength: Long = 3000
    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**
         *  replace the token here to access the APIs
         *  signup here to get free token - https://reqres.in/
         * */
        viewModel.addToken("pub_e6f930df0e1a3dd57d1bf4563223c6f8f9f4d4ebd7da133e6aa082df5006ec51")

        Handler(mainLooper).postDelayed(Runnable {

            if(viewModel.xAuth?.isEmpty() == true){
                /* Create an Intent that will start the Next - Activity. */
                val mainIntent = Intent(this, LoginActivity::class.java)
                startActivity(mainIntent)
                finish()
            }else{
                val mainIntent = Intent(this, RecyclerViewHomeActivity::class.java)
                startActivity(mainIntent)
                finish()
            }

        }, displayLength)
    }


}