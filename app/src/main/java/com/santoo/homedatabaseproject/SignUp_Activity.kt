package com.santoo.homedatabaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.santoo.homedatabaseproject.database.userDB
import com.santoo.homedatabaseproject.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUp_Activity : AppCompatActivity() {
    private lateinit var etFname: EditText
    private lateinit var etLname: EditText
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var btnSignUp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_)

        etFname = findViewById(R.id.etFname)
        etLname = findViewById(R.id.etLname)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        confirmPassword = findViewById(R.id.confirmPassword)
        btnSignUp = findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener {

            val fname = etFname.text.toString()
            val lname = etLname.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val confirmPass = confirmPassword.text.toString()

            if (password != confirmPass) {
                etPassword.error = "Password does not match"
                etPassword.requestFocus()
                return@setOnClickListener
            } else {
                val user = User(fname, lname, username, password)
                CoroutineScope(Dispatchers.IO).launch {
                    userDB
                        .getInstance(this@SignUp_Activity)
                        .getUserDAO()
                        .registerUser(user)
                    //Switiching thread to Main thread
                    withContext(Main) {
                        Toast.makeText(this@SignUp_Activity, "User registered", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            }
        }
    }
}