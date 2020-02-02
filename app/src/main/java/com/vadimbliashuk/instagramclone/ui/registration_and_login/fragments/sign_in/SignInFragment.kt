package com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.sign_in

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.vadimbliashuk.instagramclone.R
import com.vadimbliashuk.instagramclone.extension.replaceFragment
import com.vadimbliashuk.instagramclone.ui.main_ui.activities.MainActivity
import com.vadimbliashuk.instagramclone.ui.registration_and_login.activity.RegistrationOrLoginActivity
import com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.first_action.TwoButtonsFragment
import kotlinx.android.synthetic.main.sign_in_fragment.*

class SignInFragment : Fragment(), RegistrationOrLoginActivity.OnBackPressedListener {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SignInViewModel
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_in_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as RegistrationOrLoginActivity?)!!.setOnBackPressedListener(this)

        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)

        auth = FirebaseAuth.getInstance()

        btn_login_signIn_fragment.setOnClickListener {
            signInWithEmailAndPassword()
            activity!!.finish()
            startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun doBack() {
        replaceFragment(TwoButtonsFragment())
    }

    private fun signInWithEmailAndPassword() {
        if (et_email_signIn_fragment.text.toString().isEmpty()) {
            et_email_signIn_fragment.error = "Please enter Email"
            et_email_signIn_fragment.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(et_email_signIn_fragment.text.toString()).matches()) {
            et_email_signIn_fragment.error = "Please enter valid Email"
            et_email_signIn_fragment.requestFocus()
            return
        }

        if (et_password_signIn_fragment.text.toString().isEmpty()) {
            et_password_signIn_fragment.error = "Please enter password"
            et_password_signIn_fragment.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(
            et_email_signIn_fragment.text.toString(),
            et_password_signIn_fragment.text.toString()
        )

    }
}
