package com.example.passkeep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //fetching data
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "Pwd_Manager"
        ).build()
        GlobalScope.launch {
            DataObject.listdata = database.dao().getTasks() as MutableList<CardInfo>
        }
        //done
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Authentication::class.java)
            startActivity(intent)
        }, 2000)
    }

    override fun onResume() {
        super.onResume()
        val intent = Intent(this, Authentication::class.java)
        startActivity(intent)
    }
}