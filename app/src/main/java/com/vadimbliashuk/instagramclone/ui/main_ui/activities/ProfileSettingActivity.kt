package com.vadimbliashuk.instagramclone.ui.main_ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vadimbliashuk.instagramclone.R
import kotlinx.android.synthetic.main.activity_profile_settings.*

class ProfileSettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)

        iv_cancel_profile_settings.setOnClickListener {
            onBackPressed()
        }
    }
}
