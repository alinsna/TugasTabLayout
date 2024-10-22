package com.example.tugastablayout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tugastablayout.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val etEmailLogin = view.findViewById<EditText>(R.id.etEmailLogin)
        val etPasswordLogin = view.findViewById<EditText>(R.id.etPasswordLogin)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val emailLogin = etEmailLogin.text.toString()
            val passwordLogin = etPasswordLogin.text.toString()

            val sharedPreferences = requireActivity().getSharedPreferences("USER_CREDENTIALS", Context.MODE_PRIVATE)
            val registeredEmail = sharedPreferences.getString("email", "")
            val registeredPassword = sharedPreferences.getString("password", "")

            if (emailLogin == registeredEmail && passwordLogin == registeredPassword) {
                Toast.makeText(requireContext(), "Login Successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(activity, DashboardActivity::class.java))
            } else {
                Toast.makeText(requireContext(), "Invalid Email or Password", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}
