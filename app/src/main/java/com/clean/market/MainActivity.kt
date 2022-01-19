package com.clean.market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.clean.market.chatlist.ChatListFragment
import com.clean.market.home.HomeFragment
import com.clean.market.mypage.MyPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val homeFragment = HomeFragment()
        val chatListFragment = ChatListFragment()
        val myPageFragment = MyPageFragment()

        replaceFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(homeFragment)
                    Toast.makeText(this,"home",Toast.LENGTH_SHORT).show()
                }
                R.id.chatList -> {
                    replaceFragment(chatListFragment)
                    Toast.makeText(this,"chat",Toast.LENGTH_SHORT).show()
                }
                R.id.myPage -> {
                    replaceFragment(myPageFragment)
                    Toast.makeText(this,"page",Toast.LENGTH_SHORT).show()
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                Log.d("main",fragment.toString())
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }
}