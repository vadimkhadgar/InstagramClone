package com.vadimbliashuk.instagramclone.ui.registration_and_login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.vadimbliashuk.instagramclone.R
import com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.first_action.TwoButtonsFragment

class RegistrationOrLoginActivity : AppCompatActivity() {

    private var onBackPressedListener: OnBackPressedListener? = null

    interface OnBackPressedListener {
        fun doBack()
    }

    fun setOnBackPressedListener(onBackPressedListener: OnBackPressedListener?) {
        this.onBackPressedListener = onBackPressedListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_or_login)

        _replaceFragment(TwoButtonsFragment())
    }


    @Suppress("FunctionName")
    private fun _replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onDestroy() {
        onBackPressedListener = null
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (onBackPressedListener != null) {
            onBackPressedListener!!.doBack()
        } else {
            super.onBackPressed()
            //finish()
        }
    }
}
