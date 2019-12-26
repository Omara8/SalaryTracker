package com.planatech.salarytracker.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.map

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    var userId: String? = null

    enum class AuthenticationState {
        AUTHENTICATED, UNAUTHENTICATED, INVALID_AUTHENTICATION
    }

    val authenticationState = FirebaseUserLiveData().map { user ->
        if (user != null) {
            userId = user.uid
            AuthenticationState.AUTHENTICATED
        } else {
            AuthenticationState.UNAUTHENTICATED
        }
    }

}