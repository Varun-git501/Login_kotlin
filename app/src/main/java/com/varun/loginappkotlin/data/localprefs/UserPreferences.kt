package com.varun.loginappkotlin.data.localprefs

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton
import androidx.core.content.edit

/**
 *
 *  Author : @Varun Kumar
 *
 * */

@Singleton
class UserPreferences @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        const val KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        const val KEY_ID = "PREF_KEY_ID"
    }

    fun getAccessToken(): String? = prefs.getString(KEY_ACCESS_TOKEN, "")

    fun setAccessToken(token: String) = prefs.edit { putString(KEY_ACCESS_TOKEN, token) }

    fun getId(): Int = prefs.getInt(KEY_ID, 0)

    fun setId(id: Int) = prefs.edit { putInt(KEY_ID, id) }

    fun clearData() {
        prefs.edit {
            clear()
        }
    }
}