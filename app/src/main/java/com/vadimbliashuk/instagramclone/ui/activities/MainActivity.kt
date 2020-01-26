package com.vadimbliashuk.instagramclone.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vadimbliashuk.instagramclone.R
import com.vadimbliashuk.instagramclone.ui.fragments.home.HomeFragment
import com.vadimbliashuk.instagramclone.ui.fragments.notifications.NotificationsFragment
import com.vadimbliashuk.instagramclone.ui.fragments.profile.ProfileFragment
import com.vadimbliashuk.instagramclone.ui.fragments.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    moveToFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_search -> {
                    moveToFragment(SearchFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_add_post -> {
                    item.isChecked = false
                    startActivity(Intent(this@MainActivity, AddPostActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    moveToFragment(NotificationsFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    moveToFragment(ProfileFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }

            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        moveToFragment(HomeFragment())
    }

    private fun moveToFragment(fragment: Fragment) {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.nav_host_fragment, fragment)
        fragmentTrans.commit()
    }
}
