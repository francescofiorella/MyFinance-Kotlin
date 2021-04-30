package com.frafio.myfinance.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.frafio.myfinance.data.repositories.UserRepository

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()

        if (email.isNullOrEmpty()) {
            authListener?.onFailure(1)
            return
        }

        if (password.isNullOrEmpty()) {
            authListener?.onFailure(2)
            return
        }

        if (password!!.length < 8) {
            authListener?.onFailure(3)
            return
        }

        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }

    fun onResetButtotClick(view: View) {
        authListener?.onStarted()

        if (email.isNullOrEmpty()) {
            authListener?.onFailure(1)
            return
        }

        val resetResponse = UserRepository().resetPassword(email!!)
        authListener?.onSuccess(resetResponse)
    }

    fun onGoogleRequest(data: Intent?) {
        authListener?.onStarted()

        val googleResponse = UserRepository().userLogin(data)
        authListener?.onSuccess(googleResponse)
    }
}