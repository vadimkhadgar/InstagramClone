package com.vadimbliashuk.instagramclone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vadimbliashuk.instagramclone.ui.activities.SignInActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btn_already_have_account_signUp_activity.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}
