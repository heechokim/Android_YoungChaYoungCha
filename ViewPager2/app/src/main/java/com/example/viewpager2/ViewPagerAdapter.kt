package com.example.viewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    companion object {
        // 페이지 개수를 정적 변수로 선언
        private const val NUM_PAGES = 3
    }

    override fun getItemCount(): Int {
        return NUM_PAGES
    }

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