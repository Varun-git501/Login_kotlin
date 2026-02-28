package com.varun.loginappkotlin.ui.main.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.airbnb.lottie.LottieAnimationView
import com.varun.loginappkotlin.R
import com.varun.loginappkotlin.ui.main.homepage.RecyclerViewHomeActivity
import com.varun.loginappkotlin.ui.main.registration.RegistrationActivity
import com.varun.loginappkotlin.utils.common.Toaster
import com.varun.loginappkotlin.utils.common.Validator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity: AppCompatActivity() {
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
     private var tvLoginResult: TextView? = null
     private var bLogin: Button? = null
    private var bRegister: Button? = null
    private var progressbar : LottieAnimationView? = null


    private var loginViewModel: LoginViewModel? = null

    private var token : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        // Tells Dagger to inject @Inject fields

        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        //activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById<EditText>(R.id.etPassword)
        tvLoginResult = findViewById(R.id.tvLoginResult)
        bLogin = findViewById(R.id.bLogin)
        bRegister = findViewById<Button>(R.id.bRegister)
        progressbar = findViewById<LottieAnimationView>(R.id.progressBarView)

        // activityLoginBinding.setLoginBinding(getData());

        etEmail!!.setText("eve.holt@reqres.in")
        etPassword!!.setText("cityslicka")

        loginViewModel!!.getloginResponse.observe(
            this,
            Observer { token = it.data?.token

                tvLoginResult!!.setText("Login Success")
                Toaster.show(
                    this@LoginActivity,
                    "Login Successfully"
                )
                startActivity(
                    Intent(
                        this@LoginActivity,
                        RecyclerViewHomeActivity::class.java
                    )
                )
                finish()

            })
        bLogin!!.setOnClickListener(View.OnClickListener {
            loginViewModel!!.loading.observe(this, Observer {
                progressbar?.visibility = if (it) View.VISIBLE else View.GONE
            if (it) progressbar?.playAnimation()
            else progressbar?.cancelAnimation()
        })
            if (etEmail!!.text.toString().isEmpty() || etPassword!!.text.toString().isEmpty()) {
                Toaster.show(
                    this@LoginActivity,
                    "Please enter Username and Password"
                )

            } else if (!Validator.isValidEmail(etEmail!!.text.toString()))
                {
                    Toaster.show(
                        this@LoginActivity,
                                           "Please enter valid Credentials",
                    )
               } else {
                    loginViewModel!!.getLogin(etEmail!!.text.toString(), etPassword!!.text.toString())

            }

        })

        bRegister!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(intent)
        })
    }

}
