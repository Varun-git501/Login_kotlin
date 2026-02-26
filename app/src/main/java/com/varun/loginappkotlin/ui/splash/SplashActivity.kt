//package com.varun.loginappkotlin.ui.splash
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//
//import android.os.Handler
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import com.varun.loginappkotlin.databinding.ActivitySplashBinding
//import com.varun.loginappkotlin.ui.main.MainActivity
//import dagger.hilt.android.AndroidEntryPoint
//
///**
// *
// *  Author : @Varun Kumar
// *
// * */
//@SuppressLint("CustomSplashScreen")
//@AndroidEntryPoint
//class SplashActivity : AppCompatActivity() {
//    private val displayLength: Long = 3000
//    private lateinit var binding: ActivitySplashBinding
//    private val viewModel: SplashViewModel by viewModels()
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivitySplashBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        /**
//         *  replace the token here to access the APIs
//         *  signup here to get free token - https://cricketdata.org/
//         * */
//        viewModel.addToken("")
//
//        Handler(mainLooper).postDelayed(Runnable { /* Create an Intent that will start the Next - Activity. */
//            val mainIntent = Intent(this, MainActivity::class.java)
//            startActivity(mainIntent)
//            finish()
//        }, displayLength)
//    }
//
//
//}