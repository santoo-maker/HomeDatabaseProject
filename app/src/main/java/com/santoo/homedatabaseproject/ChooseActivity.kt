package com.santoo.homedatabaseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.santoo.homedatabaseproject.entity.User

class ChooseActivity : AppCompatActivity() {

    private lateinit var addStudent : Button
    private lateinit var viewStudent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        addStudent = findViewById(R.id.addStudent)
        viewStudent = findViewById(R.id.viewStudent)

        addStudent.setOnClickListener {
            val intent = Intent(this, Student_Details_Activity()::class.java)
            startActivity(intent)

        }
        viewStudent.setOnClickListener {

            val intent = Intent(this, View_Details_Activity::class.java)
            startActivity(intent)

        }
    }
}