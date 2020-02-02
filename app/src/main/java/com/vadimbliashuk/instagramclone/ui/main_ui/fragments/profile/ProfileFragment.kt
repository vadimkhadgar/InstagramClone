package com.vadimbliashuk.instagramclone.ui.main_ui.fragments.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.vadimbliashuk.instagramclone.R
import com.vadimbliashuk.instagramclone.ui.main_ui.activities.ProfileSettingActivity
import com.vadimbliashuk.instagramclone.ui.registration_and_login.activity.RegistrationOrLoginActivity
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        // TODO: Use the ViewModel

        auth = FirebaseAuth.getInstance()

        btn_edit_setting_profile_fr.setOnClickListener {
            startActivity(Intent(context, ProfileSettingActivity::class.java))
        }

        iv_sandwich.setOnClickListener {
            auth.signOut()
            startActivity(Intent(context, RegistrationOrLoginActivity::class.java))
        }
    }
}
