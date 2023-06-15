package com.example.securemiles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bottomBar = findViewById<BottomNavigationView>(R.id.bottom_bar)
        bottomBar.setOnItemSelectedListener {

            if(it.itemId==R.id.nav_safety_check){
                inflateFragment(GuardFragment.newInstance())
            }
            else if (it.itemId==R.id.nav_home){
                inflateHomeFragment(HomeFragment.newInstance())
            }

            true
        }

    }

    private fun inflateHomeFragment(newInstance: HomeFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, HomeFragment.newInstance())
        transaction.commit()
    }

    private fun inflateFragment(newInstance: GuardFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, newInstance)
        transaction.commit()

    }

}