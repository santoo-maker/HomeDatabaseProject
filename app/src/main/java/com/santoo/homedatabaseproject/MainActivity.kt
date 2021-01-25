package com.santoo.homedatabaseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.santoo.homedatabaseproject.database.userDB
import com.santoo.homedatabaseproject.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.sign

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var signUp: TextView
    val username = "s"
    val password = "s"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        signUp = findViewById(R.id.signUp)

        signUp.setOnClickListener {

            val intent = Intent(this, SignUp_Activity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        var user: User? = null
        CoroutineScope(Dispatchers.IO).launch {
            user = userDB
                    .getInstance(this@MainActivity)
                    .getUserDAO()
                    .checkUser(username, password)
            if (user == null) {
                withContext(Main) {
                    Toast.makeText(this@MainActivity, "Invalid credentials", Toast.LENGTH_SHORT)
                            .show()
                }
            } else {
                startActivity(Intent(this@MainActivity,
                        ChooseActivity::class.java))
            }


        }
    }
}