package com.vadimbliashuk.instagramclone.ui.yyy_activities.sign_up_activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vadimbliashuk.instagramclone.R
import com.vadimbliashuk.instagramclone.ui.yyy_activities.SignInActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btn_already_have_account_signUp_activity.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }

        btn_sign_up_signUp_activity.setOnClickListener {
            TODO()
        }

        when {
            et_fullName_signUp_activity.text.isEmpty() -> {
                et_fullName_signUp_activity.error = "Required"
            }
            et_userName_signUp_activity.text.isEmpty() -> {
                et_fullName_signUp_activity.error = "Required"
            }
            et_email_signUp_activity.text.isEmpty() -> {
                et_fullName_signUp_activity.error = "Required"
            }
            et_password_signUp_activity.text.isEmpty() -> {
                et_fullName_signUp_activity.error = "Required"
            }
        }
    }
}
