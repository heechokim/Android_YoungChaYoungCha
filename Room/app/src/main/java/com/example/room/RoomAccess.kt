package com.example.room

import android.content.Context
import androidx.room.Room

class RoomAccess(context: Context) {

    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "choheeDB"
    ).build()

    fun insertAll(user: User){
        val inserThread = Thread(Runnable {
            db.userDao().inserAll(user)
        })
        inserThread.start()
    }

    fun getById(id: Int): List<User>{

        var userInfo = listOf<User>()
        val getThread = Thread(Runnable {
            userInfo = db.userDao().loadAllByIds(id)
        })
        getThread.start()

        getThread.join()
        return userInfo
    }
}



