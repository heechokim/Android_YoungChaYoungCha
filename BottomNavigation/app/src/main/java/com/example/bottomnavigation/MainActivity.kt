package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(Fragment1())

        bottomNavBar.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.action_search -> {
                    replaceFragment(Fragment1())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_settings -> {
                    replaceFragment(Fragment2())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_navigation -> {
                    replaceFragment(Fragment3())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }

        }

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}
