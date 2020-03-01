package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

// 1. 슬라이드에 참여하는 화면 수를 전역변수로 설정
private const val NUM_PAGES = 3

class MainActivity : AppCompatActivity() {

    // 2. ViewPager 변수를 나중에(onCreate함수 내에서) 초기화하겠다고 선언
    private lateinit var myPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 3. myPager 변수에 xml에 작성한 viewPager 대입
        myPager = findViewById(R.id.viewPager)

        // 5. pagerAdapter 변수에 Adapter 클래스 대입
        val pagerAdapter: PagerAdapter = ViewPagerAdapter(supportFragmentManager)
        myPager.adapter = pagerAdapter

    }

    // 6. 뒤로가기 버튼 클릭시 해줄 것들 추가 세팅
    override fun onBackPressed() {
        if(myPager.currentItem == 0){
            // 만약 유저가 슬라이드 화면 중 제일 첫 화면을 보고 있을 경우에 Back버튼을 누르면 어플이 finish 됨
            super.onBackPressed()
        }else{
            // 아닐경우 Back 버튼 누르면 이전 화면으로 슬라이드되면서 이동
            myPager.currentItem = myPager.currentItem - 1
        }
    }


    // 4. ViewPager가 참조할 ViewPagerAdapter 클래스를 inner 클래스로 생성
    private inner class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            // 슬라이드 position 마다 어떤 화면을 띄워줄지를 결정
            return when (position) {
                0 -> return Fragment1()
                1 -> return Fragment2()
                2 -> return Fragment3()
                else -> Fragment1()
            }
        }
        override fun getCount(): Int = NUM_PAGES

    }
}
