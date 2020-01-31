package com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.sign_in

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vadimbliashuk.instagramclone.R
import com.vadimbliashuk.instagramclone.extension.replaceFragment
import com.vadimbliashuk.instagramclone.ui.registration_and_login.activity.RegistrationOrLoginActivity
import com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.first_action.TwoButtonsFragment

class SignInFragment : Fragment(), RegistrationOrLoginActivity.OnBackPressedListener {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SignInViewModel

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
        // TODO: Use the ViewModel
    }

    override fun doBack() {
        replaceFragment(TwoButtonsFragment())
    }
}
