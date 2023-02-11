package com.example.passkeep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_authentication.*

class Authentication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)





        login_button.setOnClickListener {
            var email_auth = login_email.text.toString()
            var pass_auth = login_password.text.toString()

            if(email_auth == "test@admin.com" && pass_auth == "12345678"){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(getBaseContext(), "Invalid credentials...Hint: Use credentials as mentioned \n in GDSC NSUT Recruitment Task Document", Toast.LENGTH_LONG).show()
            }

        }





    }
}