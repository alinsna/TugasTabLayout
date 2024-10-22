package com.example.tugastablayout

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugastablayout.R

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name = "Alin Septiani Nur Aisyah"
        val nim = "23/520895/SV/23320"

        findViewById<TextView>(R.id.tvName).text = "Nama: $name"
        findViewById<TextView>(R.id.tvNim).text = "NIM: $nim"

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}
