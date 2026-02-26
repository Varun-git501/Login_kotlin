package com.varun.loginappkotlin.ui.main

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
class RegistrationActivity: AppCompatActivity() {
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var etFirstName: EditText? = null
    private var etLastName: EditText? = null
    private var tvRegisterResult: TextView? = null
    private var bRegister: Button? = null

    private var registrationViewModel: RegistrationViewModel? = null

    private var token : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registrationViewModel = ViewModelProvider(this)[RegistrationViewModel::class.java]
        //activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        setContentView(R.layout.activity_registration)
        Toaster.show(this@RegistrationActivity,"Registration Activity" )
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById<EditText>(R.id.etPassword)
        etLastName = findViewById(R.id.etLastName)
        tvRegisterResult = findViewById(R.id.tvRegisterResult)
        bRegister = findViewById<Button>(R.id.bRegister1)

        registrationViewModel!!.getRegistrationResponse.observe(
            this,
            Observer { token = it.data?.token

                tvRegisterResult!!.setText("Registration Success")

                Toaster.show(
                    this@RegistrationActivity,
                    "Registration Successfully"
                )

                    finish()
            })
        bRegister!!.setOnClickListener(View.OnClickListener {
            if (etEmail!!.text.toString().isEmpty() || etPassword!!.text.toString().isEmpty()) {
                Toaster.show(
                    this@RegistrationActivity,
                    "Please enter Username and Password"
                )

            } else if (!Validator.isValidEmail(etEmail!!.text.toString()))
            {
                Toaster.show(
                    this@RegistrationActivity,
                    "Please enter valid Credentials",
                )
            } else {
                Toaster.show(
                    this@RegistrationActivity,
                    etEmail!!.text.toString()+"\n"+ etPassword!!.text.toString()
                )
                registrationViewModel!!.getRegistration(etEmail!!.text.toString(), etPassword!!.text.toString())
//                registrationViewModel!!.getRegistration(etEmail!!.text.toString(), etPassword!!.text.toString(),etFirstName!!.text.toString(), etLastName!!.text.toString())
            }
        })

    }

}
