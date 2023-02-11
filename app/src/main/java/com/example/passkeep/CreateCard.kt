package com.example.passkeep


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class CreateCard : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "Pwd_Manager"
        ).build()
        save_button.setOnClickListener {
            if (create_website.text.toString().trim { it <= ' ' }.isNotEmpty()
                && create_email.text.toString().trim { it <= ' ' }.isNotEmpty()
                && create_password.text.toString().trim { it <= ' ' }.isNotEmpty()
            ) {
                var title = create_website.getText().toString()
                var priority = create_email.getText().toString()
                var password = create_password.getText().toString()
                DataObject.setData(title, priority,password)
                GlobalScope.launch {
                    database.dao().insertTask(Entity(0, title, priority,password))

                }

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

