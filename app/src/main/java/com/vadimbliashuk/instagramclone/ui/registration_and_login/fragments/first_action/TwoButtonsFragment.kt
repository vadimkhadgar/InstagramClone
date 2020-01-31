package com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.first_action


import android.os.Bundle
import androidx.fragment.app.Fragment
import com.vadimbliashuk.instagramclone.R
import com.vadimbliashuk.instagramclone.extension.replaceFragment
import com.vadimbliashuk.instagramclone.ui.registration_and_login.activity.RegistrationOrLoginActivity
import com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.sign_in.SignInFragment
import com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.sign_up.SignUpFragment
import kotlinx.android.synthetic.main.fragment_two_buttons.*

/**
 * A simple [Fragment] subclass.
 */
class TwoButtonsFragment : Fragment(R.layout.fragment_two_buttons),
    RegistrationOrLoginActivity.OnBackPressedListener {

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_two_buttons, container, false)
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as RegistrationOrLoginActivity?)!!.setOnBackPressedListener(this)

        btn_sign_in_two_buttons_frag.setOnClickListener {
            replaceFragment(SignInFragment())
        }

        btn_sign_up_two_buttons_frag.setOnClickListener {
            replaceFragment(SignUpFragment())
        }
    }

    override fun doBack() {
        activity!!.finish()
    }
}
