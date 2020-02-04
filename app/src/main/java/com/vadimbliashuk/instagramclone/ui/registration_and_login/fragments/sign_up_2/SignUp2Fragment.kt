package com.vadimbliashuk.instagramclone.ui.registration_and_login.fragments.sign_up_2


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vadimbliashuk.instagramclone.R
import kotlinx.android.synthetic.main.fragment_sign_up_2.*

/**
 * A simple [Fragment] subclass.
 */
class SignUp2Fragment : Fragment() {

    private val TAG = "_SignUp2Fragment"
    private val GALLERY_REQUEST_CODE = 1234

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up_2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//            startActivity(Intent(context, MainActivity::class.java))
//            activity!!.finish()

        btn_select_photo_register.setOnClickListener {
            pickPhotoFromGallery()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            GALLERY_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {

                } else {
                    Log.e(TAG, "Image selection error: couldn't select image from memory")
                }
            }
        }
    }

    private fun pickPhotoFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image"
        val mimeType = arrayOf("image/jpeg", "image/png", "image/jpg")
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeType)
        intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

}
