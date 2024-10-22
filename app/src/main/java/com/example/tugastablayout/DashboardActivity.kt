package com.example.tugastablayout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugastablayout.R

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val sharedPreferences = getSharedPreferences("USER_CREDENTIALS", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "User")
        val email = sharedPreferences.getString("email", "example@mail.com")

        findViewById<TextView>(R.id.tvWelcome).text = "Welcome, $name!"

        findViewById<TextView>(R.id.tvName).text = "Name: $name"
        findViewById<TextView>(R.id.tvEmail).text = "Email: $email"

        val btnProfile = findViewById<ImageView>(R.id.btnProfile)
        val btnLogout = findViewById<ImageView>(R.id.btnLogout)

        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        btnLogout.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}