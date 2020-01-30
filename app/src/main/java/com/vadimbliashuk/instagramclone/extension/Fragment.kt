package com.vadimbliashuk.instagramclone.extension

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.vadimbliashuk.instagramclone.R

fun Fragment.replaceFragment(fragment: Fragment) {
    val fragmentManager = activity!!.supportFragmentManager
    val transaction: FragmentTransaction = fragmentManager.beginTransaction()
    transaction.replace(R.id.fragment_container, fragment)
    transaction.commit()
}

@Suppress("unused")
fun Any.toast(context: Context, message: String): Toast {
    return Toast.makeText(
        context, message, Toast.LENGTH_LONG
    ).apply { show() }
}