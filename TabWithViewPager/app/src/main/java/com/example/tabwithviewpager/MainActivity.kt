package com.example.tabwithviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    //1. tabLayout 뷰 객체 초기화 지연시키기
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. tablayout 뷰 객체 초기화하기
        tabLayout = findViewById(R.id.tab_layout)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
                // handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // handle tab unselect
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                // handle tab select
                Toast.makeText(applicationContext, "탭 눌림", Toast.LENGTH_SHORT).show()
            }
        })

        viewPager2 = findViewById(R.id.view_pager2)
        viewPager2.adapter = ViewPagerAdapter(this)

        // 3. tabLayout과 ViewPager 연결시키기
        TabLayoutMediator(tabLayout, viewPager2) {tab, position ->
            when(position) {
                0 -> tab.text = "탭1"
                1 -> tab.text = "탭2"
                2 -> tab.text = "탭3"
            }
        }.attach()
    }

    inner class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            if(position == 0) {
                return Fragment1()
            }else if(position == 1) {
                return Fragment2()
            }else {
                return Fragment3()
            }
        }
    }
}