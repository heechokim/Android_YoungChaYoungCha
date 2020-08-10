package com.example.appbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "네비게이션 버튼", Toast.LENGTH_SHORT).show()
            // Handle 네비게이션 아이콘 press
        }

        topAppBar.setOnMenuItemClickListener { item: MenuItem? ->
            when(item?.itemId) {
                R.id.favorite -> {
                    Toast.makeText(this, "하트버튼", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, "검색버튼", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "더보기버튼", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}