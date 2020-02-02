package com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.sign_up

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.vadimbliashuk.instagramclone.R
import com.vadimbliashuk.instagramclone.extension.replaceFragment
import com.vadimbliashuk.instagramclone.ui.main_ui.activities.MainActivity
import com.vadimbliashuk.instagramclone.ui.registration_and_login.activity.RegistrationOrLoginActivity
import com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.first_action.TwoButtonsFragment
import kotlinx.android.synthetic.main.sign_up_fragment.*

class SignUpFragment : Fragment(), RegistrationOrLoginActivity.OnBackPressedListener {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: SignUpViewModel
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_up_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as RegistrationOrLoginActivity?)!!.setOnBackPressedListener(this)

        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        auth = FirebaseAuth.getInstance()
        btn_next_signUp_fragment.setOnClickListener {
            performRegister()
            startActivity(Intent(context, MainActivity::class.java))
            activity!!.finish()
        }
    }

    override fun doBack() {
        replaceFragment(TwoButtonsFragment())
    }

    private fun performRegister() {
        if (et_email_signUp_fragment.text.toString().isEmpty()) {
            et_email_signUp_fragment.error = "Please enter Email"
            et_email_signUp_fragment.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(et_email_signUp_fragment.text.toString()).matches()) {
            et_email_signUp_fragment.error = "Please enter valid Email"
            et_email_signUp_fragment.requestFocus()
            return
        }

        if (et_password_signUp_fragment.text.toString().isEmpty()) {
            et_password_signUp_fragment.error = "Please enter password"
            et_password_signUp_fragment.requestFocus()
            return
        }


        if (et_password_signUp_fragment.text.toString().length < 6) {
            et_password_signUp_fragment.error = "Password must be at least 6 characters"
            et_password_signUp_fragment.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(
            et_email_signUp_fragment.text.toString(),
            et_password_signUp_fragment.text.toString()
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(
                    "_SignUpFragment",
                    "signInWithEmail:success, User UID ${auth.currentUser!!.uid}"
                )
                // uploadImageToFireBaseStorage()
            } else {
                // If sign in fails, display a message to the user.
                Log.w("_SignUpFragment", "signInWithEmail:failure", task.exception)
                Toast.makeText(
                    context, "Authentication failed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
