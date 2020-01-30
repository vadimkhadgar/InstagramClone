package com.vadimbliashuk.instagramclone.ui.main_ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.vadimbliashuk.instagramclone.ui.registration_and_login.activity.RegistrationOrLoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (FirebaseAuth.getInstance().currentUser == null)
            startActivity(Intent(this, RegistrationOrLoginActivity::class.java))
        else
            startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
