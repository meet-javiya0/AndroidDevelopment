package com.example.shoppingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // By default home fragment is visible
        replaceWithFragment(Home())

        bottomView.selectedItemId = R.id.Home

        bottomView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.search -> replaceWithFragment(Search())
                R.id.Categories -> replaceWithFragment(Categories())
                R.id.Home -> replaceWithFragment(Home())
                R.id.Cart -> replaceWithFragment(Cart())
                R.id.MyAccount -> replaceWithFragment(MyAccount())
            }
            true
        }
    }

    private fun replaceWithFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FrameLayout, fragment)
        fragmentTransaction.commit()
    }
}