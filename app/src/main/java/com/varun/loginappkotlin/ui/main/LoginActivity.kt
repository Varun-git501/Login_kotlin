package com.varun.loginappkotlin.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.varun.loginappkotlin.R
import com.varun.loginappkotlin.data.remote.request.DataRequest
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

    private var loginViewModel: LoginViewModel? = null

    private var token : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
//        ((MyApp) getApplication()).appComponent.inject(this);
        // Tells Dagger to inject @Inject fields

        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        //activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        setContentView(R.layout.activity_login)
        Toaster.show(this@LoginActivity,"LOGIN Activity" )
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById<EditText>(R.id.etPassword)
        tvLoginResult = findViewById(R.id.tvLoginResult)
        bLogin = findViewById(R.id.bLogin)
        bRegister = findViewById<Button>(R.id.bRegister)

        // activityLoginBinding.setLoginBinding(getData());

//        loginViewModel = new ViewModelProvider(this,loginVMFactory).get(LoginViewModel.class);
//

        loginViewModel!!.getloginResponse.observe(
            this,
            Observer { token = it.data?.token


                tvLoginResult!!.setText("Login Success")
                Toaster.show(
                    this@LoginActivity,
                    "Login Successfully"
                )
                Log.e( "LoginActivity: ", "Login Successfully")
                startActivity(
                    Intent(
                        this@LoginActivity,
                        RecyclerViewHomeActivity::class.java
                    )
                )
//                if (voidLoginResponse.data) {
//                    Log.e("login onChanged: activity ", voidLoginResponse)
//



//                startActivity(new Intent(getApplicationContext(), ListViewHomeActivity.class));

//                    finish()
//                }
            })
        bLogin!!.setOnClickListener(View.OnClickListener {
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
                   etEmail!!.setText("eve.holt@reqres.in")
                    etPassword!!.setText("cityslicka")
                    loginViewModel!!.getLogin(etEmail!!.text.toString(), etPassword!!.text.toString())
            }
        })

        bRegister!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, RegistrationActivity::class.java)
//            intent.putExtra("TOKEN", token)
            startActivity(intent)
        })
    }

}
