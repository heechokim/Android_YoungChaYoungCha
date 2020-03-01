package com.example.bottomnavigationbarwithviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


private const val NUM_PAGES = 3

class MainActivity : AppCompatActivity() {

    private lateinit var myPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myPager = findViewById(R.id.viewPager)

        val pagerAdapter: PagerAdapter = ViewPagerAdpater(supportFragmentManager)
        myPager.adapter = pagerAdapter

        // 1. BottomNavigation에 각 탭을 클릭했을 때 반응하는 리스너 설정
        // --> BottomNavigation의 각 탭을 클릭하면 ViewPager로 화면이 슬라이드 되도록 하기 위함!
        bottomNavigationBar.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener{
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when(item.itemId){
                        R.id.item_calls -> {
                            // ViewPager의 현재 item에 첫 번째 화면을 강제 대입
                            myPager.currentItem = 0
                            return true
                        }
                        R.id.item_chats -> {
                            // ViewPager의 현재 item에 두 번째 화면을 강제 대입
                            myPager.currentItem = 1
                            return true
                        }
                        R.id.item_contacts -> {
                            // ViewPager의 현재 item에 세 번째 화면을 강제 대입
                            myPager.currentItem = 2
                            return true
                        }
                        else -> {
                            return false
                        }
                    }
                }
            }
        )

        // 2. ViewPager의 page가 변하면 반응하는 리스너 설정
        // --> 슬라이드로 해당 page가 선택되면 BottomNavigation의 해당 탭을 활성화하기 위함!
        viewPager.addOnPageChangeListener(
            object : ViewPager.OnPageChangeListener{
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                // 슬라이드로 해당 page가 선택되면 BottomNavigation의 해당 탭을 활성화하기
                override fun onPageSelected(position: Int) {
                    bottomNavigationBar.menu.getItem(position).isChecked = true
                }

                override fun onPageScrollStateChanged(state: Int) {
                }

            }
        )

    }

    override fun onBackPressed() {
        if(myPager.currentItem == 0){
            super.onBackPressed()
        }else {
            myPager.currentItem = myPager.currentItem - 1
        }
    }

    inner class ViewPagerAdpater(fm: FragmentManager) : FragmentStatePagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            return when(position){
                0 -> return Fragment1()
                1 -> return Fragment2()
                2 -> return Fragment3()
                else -> Fragment1()
            }
        }

        override fun getCount(): Int = NUM_PAGES

    }
}


