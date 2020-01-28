package com.vadimbliashuk.instagramclone.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vadimbliashuk.instagramclone.R
import com.vadimbliashuk.instagramclone.SignUpActivity
import kotlinx.android.synthetic.main.activity_signin.*

class SignInActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        btn_new_account_signIn_activity.setOnClickListener {
            startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
        }

        btn_sign_in_signIn_activity.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            Toast.makeText(this, "Test", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
