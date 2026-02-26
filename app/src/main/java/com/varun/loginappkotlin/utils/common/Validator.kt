package com.varun.loginappkotlin.utils.common

import android.util.Patterns

class Validator {
//    fun isValidEmail(email: String?): Boolean? {
//        return email?.let { Patterns.EMAIL_ADDRESS.matcher(it).matches() }
//    }

//    fun isValidPassword(password: String): Boolean {
//        // Add your password validation logic here
//        return password.length >= 6
//    }

    companion object {
        fun isValidEmail(email: Any): Boolean {
            return email.let { Patterns.EMAIL_ADDRESS.matcher(it.toString()).matches() }
        }
        fun isValidPassword(password: Any): Boolean {
            return password.let { Patterns.EMAIL_ADDRESS.matcher(it.toString()).matches() }
        }
    }
}