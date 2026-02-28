package com.varun.loginappkotlin.utils.common

import android.util.Patterns

class Validator {
    companion object {
        fun isValidEmail(email: Any): Boolean {
            return email.let { Patterns.EMAIL_ADDRESS.matcher(it.toString()).matches() }
        }
        fun isValidPassword(password: Any): Boolean {
            return password.let { Patterns.EMAIL_ADDRESS.matcher(it.toString()).matches() }
        }
    }
}