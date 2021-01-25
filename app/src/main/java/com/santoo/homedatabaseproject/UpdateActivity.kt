package com.santoo.homedatabaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.santoo.homedatabaseproject.entity.Student

class UpdateActivity : AppCompatActivity() {
    private lateinit var etFullName : EditText
    private lateinit var etAge : EditText
    private lateinit var btnUpdate : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        etFullName = findViewById(R.id.etFullName)
        etAge = findViewById(R.id.etAge)
        btnUpdate = findViewById(R.id.btnUpdate)

        val intent = intent.getParcelableExtra<Student>()

    }
}