package com.santoo.homedatabaseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.santoo.homedatabaseproject.database.userDB
import com.santoo.homedatabaseproject.entity.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

        val intent = intent.getParcelableExtra<Student>("student")
        if (intent != null) {
            etFullName.setText(intent.fullName)
            etAge.setText(intent.age.toString())
        }

        btnUpdate.setOnClickListener {
            val student = Student(fullName = etFullName.text.toString(),age = etAge.text.toString().toInt())
            student.stdId = intent!!.stdId

            CoroutineScope(Dispatchers.IO).launch {
                userDB.getInstance(this@UpdateActivity).getStudentDAO().updateStudent(student)
                withContext(Main){
                startActivity(Intent(this@UpdateActivity,View_Details_Activity::class.java))
                }
            }
        }


    }
}