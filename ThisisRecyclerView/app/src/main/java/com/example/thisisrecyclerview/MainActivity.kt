package com.example.thisisrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rv_main: RecyclerView
    private lateinit var rv_Adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        rv_main = findViewById(R.id.rv_MAIN)
        rv_Adapter = Adapter(this)
        rv_main.adapter = rv_Adapter
        rv_main.layoutManager = LinearLayoutManager(this)
        rv_Adapter.data = listOf(
            DataDefine(
                name = "SoptStagram",
                description = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
                language = "Kotilin"
            ),
            DataDefine(
                name = "ChoheeBlog",
                description = "초희 개인 블로그",
                language = "Markdown"
            ),
            DataDefine(
                name = "Nodejs",
                description = "Nodejs 스터디 자료들",
                language = "JavaScript"
            ),
            DataDefine(
                name = "Android 라이브러리",
                description = "안드로이드 개발 라이브러리",
                language = "Kotilin"
            ),
            DataDefine(
                name = "리사이클러뷰~~~",
                description = "걍 채우는 아이템~~^^",
                language = "Kotilin"
            )
        )
        rv_Adapter.notifyDataSetChanged()
    }
}

