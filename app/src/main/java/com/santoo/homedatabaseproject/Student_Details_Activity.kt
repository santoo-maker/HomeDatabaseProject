package com.santoo.homedatabaseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.santoo.homedatabaseproject.database.userDB
import com.santoo.homedatabaseproject.entity.Student
import com.santoo.homedatabaseproject.entity.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import java.lang.Exception

class Student_Details_Activity : AppCompatActivity() {

    private lateinit var etFirst : EditText
    private lateinit var etSecond : EditText
    private lateinit var rdoGroup : RadioGroup
    private lateinit var male : RadioButton
    private lateinit var female : RadioButton
    private lateinit var others : RadioButton
    private lateinit var etAddress : EditText
    private lateinit var btnAdd : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student__details_)

        etFirst = findViewById(R.id.etFirst)
        etSecond = findViewById(R.id.etSecond)
        rdoGroup = findViewById(R.id.rdoGroup)
        male = findViewById(R.id.male)
        female = findViewById(R.id.female)
        others = findViewById(R.id.others)
        etAddress = findViewById(R.id.etAddress)
        btnAdd = findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener {

            var fullName = etFirst.text.toString()
            var age = etSecond.text.toString().toInt()
            var address = etAddress.text.toString()
            var gender = ""

            when {
                male.isSelected -> {
                    gender = "male"
                }

                female.isSelected -> {
                    gender = "female"
                }

                others.isSelected -> {
                    gender = "others"
                }

            }
            var student = Student(fullName, age, gender, address)

            try {
                CoroutineScope(Dispatchers.IO).launch {

                    userDB.getInstance(this@Student_Details_Activity).getStudentDAO().insertStudent(student)
                    withContext(Main)
                    {
                        Toast.makeText(this@Student_Details_Activity, "Student Added", Toast.LENGTH_LONG).show()
                    }

                }
            }
            catch (ex: Exception) {
                Toast.makeText(this, "Error ${ex.localizedMessage}", Toast.LENGTH_SHORT).show()
            }


        }
    }
}