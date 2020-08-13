package com.example.viewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : FragmentActivity() {

    companion object {
        // 페이지 개수를 정적 변수로 선언
        private const val NUM_PAGES = 3
    }

    // 1. activity_main.xml 에 존재하는 viewPager2 뷰 객체 선언을 onCreateView 뒤로 미룸
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. onCreateView 함수가 호출된 후 뷰 객체를 초기화함
        viewPager2 = findViewById(R.id.viewPager2)

        // 4. viewPager 뷰 객체에 어댑터 적용하기
        viewPager2.adapter = ViewPagerAdapter(this)
    }

    // 5. back 버튼 클릭시 화면 슬라이드 과거로 이동시키기
    override fun onBackPressed() {
        if(viewPager2.currentItem == 0) {
            super.onBackPressed()
        }else {
            viewPager2.currentItem = viewPager2.currentItem - 1
        }
    }

    // 3. ViewPagerAdapter 클래스 만들기
    inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return NUM_PAGES
        }

        // position에 따라 Fragment 바꿔주기
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