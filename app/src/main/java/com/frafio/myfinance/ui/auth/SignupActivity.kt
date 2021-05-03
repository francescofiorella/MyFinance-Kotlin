package com.frafio.myfinance.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.frafio.myfinance.R
import com.frafio.myfinance.data.repositories.UserRepository
import com.frafio.myfinance.databinding.ActivitySignupBinding
import com.frafio.myfinance.ui.home.MainActivity
import com.frafio.myfinance.utils.snackbar
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity(), AuthListener {

    // definizione variabili
    lateinit var layout: RelativeLayout

    lateinit var mToolbar: MaterialToolbar
    lateinit var mFullNameLayout: TextInputLayout
    lateinit var mEmailLayout:TextInputLayout
    lateinit var mPasswordLayout:TextInputLayout
    lateinit var mPasswordAgainLayout:TextInputLayout
    lateinit var mProgressIndicator: LinearProgressIndicator

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = UserRepository()
        val factory = AuthViewModelFactory(repository)

        val binding: ActivitySignupBinding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        val viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this

        // toolbar
        mToolbar = findViewById(R.id.signup_toolbar)
        setSupportActionBar(mToolbar)

        // back arrow
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // collegamento view
        layout = findViewById(R.id.signup_layout)

        mFullNameLayout = findViewById(R.id.signup_nameInputLayout)
        mEmailLayout = findViewById(R.id.signup_emailInputLayout)
        mPasswordLayout = findViewById(R.id.signup_passwordInputLayout)
        mPasswordAgainLayout = findViewById(R.id.signup_passwordAgainInputLayout)

        mProgressIndicator = findViewById(R.id.signup_progressIndicator)
    }

    override fun onAuthStarted() {
        mProgressIndicator.show()

        mFullNameLayout.isErrorEnabled = false
        mEmailLayout.isErrorEnabled = false
        mPasswordLayout.isErrorEnabled = false
        mPasswordAgainLayout.isErrorEnabled = false
    }

    override fun onAuthSuccess(response: LiveData<Any>) {
        response.observe(this, Observer { responseData ->
            mProgressIndicator.hide()

            when (responseData) {
                1 -> {
                    val returnIntent = Intent()
                    setResult(RESULT_OK, returnIntent)
                    finish()
                }
                2 -> mPasswordAgainLayout.error = "Le password inserite non corrispondono!"
                3 -> mEmailLayout.error = "L'email inserita non è ben formata."
                4 -> mEmailLayout.error = "L'email inserita ha già un account associato."
                is String -> layout.snackbar(responseData)
            }
        })
    }

    override fun onAuthFailure(errorCode: Int) {
        mProgressIndicator.hide()

        when (errorCode) {
            1 -> mFullNameLayout.error = "Inserisci nome e cognome."
            2 -> mEmailLayout.error = "Inserisci la tua email."
            3 -> mPasswordLayout.error = "Inserisci la password."
            4 -> mPasswordLayout.error = "La password deve essere lunga almeno 8 caratteri!"
            5 -> mPasswordAgainLayout.error = "Inserisci nuovamente la password."
            6 -> mPasswordAgainLayout.error = "Le password inserite non corrispondono!"
        }
    }

    fun goToLoginActivity(view: View) {
        finish()
    }

    // ends this activity (back arrow)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}