package com.example.passkeep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.android.synthetic.main.activity_update_card.create_email
import kotlinx.android.synthetic.main.activity_update_card.create_password
import kotlinx.android.synthetic.main.activity_update_card.create_website
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateCard : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "Pwd_Manager"
        ).build()
        val pos = intent.getIntExtra("id", -1)
        if (pos != -1) {
            val website = DataObject.getData(pos).website
            val email = DataObject.getData(pos).email
            val password = DataObject.getData(pos).password
            create_website.setText(website)
            create_email.setText(email)
            create_password.setText((password))

            delete_button.setOnClickListener {
                DataObject.deleteData(pos)
                GlobalScope.launch {
                    database.dao().deleteTask(
                        Entity(
                            pos + 1,
                            create_website.text.toString(),
                            create_email.text.toString(),
                            create_password.text.toString()
                        )
                    )
                }
                myIntent()
            }

            update_button.setOnClickListener {
                DataObject.updateData(
                    pos,
                    create_website.text.toString(),
                    create_email.text.toString(),
                    create_password.text.toString()
                )
                GlobalScope.launch {
                    database.dao().updateTask(
                        Entity(
                            pos + 1, create_website.text.toString(),
                            create_email.text.toString(),
                            create_password.text.toString()
                        )
                    )
                }
                myIntent()
            }

        }
    }

    fun myIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}