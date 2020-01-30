package com.vadimbliashuk.instagramclone.ui.registration_and_login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.vadimbliashuk.instagramclone.R
import com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.first_action.TwoButtonsFragment

class RegistrationOrLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_or_login)

        replaceFragment(TwoButtonsFragment())
    }


    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        //       super.onBackPressed()
        finish()
    }
}
