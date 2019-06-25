package com.example.webview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /** activity_main.xml 뷰 변수 선언 및 초기화 */
        val myWebView = findViewById<View>(R.id.main_wv) as WebView

        /** 웹뷰 세팅 */
        val settings = myWebView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true

        /** 웹뷰 띄우기 */
        myWebView.loadUrl("https://choheeis.github.io/")
    }
}
