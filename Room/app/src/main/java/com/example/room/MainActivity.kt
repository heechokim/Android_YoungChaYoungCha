package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        RoomAccess(this).insertAll(User(1, "chohee", "Kim"))
        Log.d("chohee", RoomAccess(this).getById(1).toString())


    }


}




