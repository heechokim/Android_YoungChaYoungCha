package com.example.awsamplifybuild

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amazonaws.mobile.config.AWSConfiguration
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient
import com.amazonaws.mobile.client.UserStateDetails
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobile.client.Callback
import android.R
import android.view.View
import android.widget.TextView
import com.amazonaws.mobile.client.UserState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mAWSAppSyncClient : AWSAppSyncClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // AWS AppSync 클라이언트 초기화
        mAWSAppSyncClient = AWSAppSyncClient.builder().context(applicationContext).awsConfiguration(AWSConfiguration(applicationContext)).build()

        AWSMobileClient.getInstance().initialize(applicationContext, object : Callback<UserStateDetails> {
            override fun onResult(userStateDetails: UserStateDetails) {
                when (userStateDetails.userState) {
                    UserState.SIGNED_IN -> runOnUiThread {
                        val textView = findViewById<View>(R.id.text) as TextView
                        textView.text = "Logged IN"
                    }
                    UserState.SIGNED_OUT -> runOnUiThread {
                        val textView = findViewById<View>(R.id.text) as TextView
                        textView.text = "Logged OUT"
                    }
                    else -> AWSMobileClient.getInstance().signOut()
                }
            }

            override fun onError(e: Exception) {
                Log.e("INIT", e.toString())
            }
        })

    }
}
