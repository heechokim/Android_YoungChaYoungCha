package com.example.viewpager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    // 1. activity_main.xml 에 존재하는 viewPager2 뷰 객체 선언을 onCreateView 뒤로 미룸
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. onCreateView 함수가 호출된 후 뷰 객체를 초기화함
        viewPager2 = findViewById(R.id.viewPager2)

        // 3. viewPager 뷰 객체에 어댑터 적용하기
        viewPager2.adapter = ViewPagerAdapter(this)
    }

    // 추가 기능 ) back 버튼 클릭시 화면 슬라이드 과거로 이동시키기
    override fun onBackPressed() {
        if(viewPager2.currentItem == 0) {
            super.onBackPressed()
        }else {
            viewPager2.currentItem = viewPager2.currentItem - 1
        }
    }
}