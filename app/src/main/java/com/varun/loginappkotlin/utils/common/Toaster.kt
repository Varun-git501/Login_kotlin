package com.varun.loginappkotlin.utils.common

import android.content.Context
import android.widget.Toast
/**
 *
 *  Author : @Varun Kumar
 *
 * */
object Toaster {
    fun show(context: Context, text: CharSequence) {
        val toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
        toast.show()
    }

}