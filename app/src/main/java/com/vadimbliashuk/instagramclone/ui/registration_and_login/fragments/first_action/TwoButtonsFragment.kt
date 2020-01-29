package com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.first_action


import android.os.Bundle
import androidx.fragment.app.Fragment
import com.vadimbliashuk.instagramclone.R
import kotlinx.android.synthetic.main.fragment_two_buttons.*

/**
 * A simple [Fragment] subclass.
 */
class TwoButtonsFragment : Fragment(R.layout.fragment_two_buttons) {

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_two_buttons, container, false)
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_sign_in_two_buttons_frag.setOnClickListener {
            TODO()
        }

        btn_sign_up_two_buttons_frag.setOnClickListener {
            TODO()
        }
    }
}
