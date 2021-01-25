package com.santoo.homedatabaseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.santoo.homedatabaseproject.entity.User

class Student_Details_Activity : AppCompatActivity() {

    private lateinit var etFirst : EditText
    private lateinit var etSecond : EditText
    private lateinit var rdoGroup : RadioGroup
    private lateinit var male : RadioButton
    private lateinit var female : RadioButton
    private lateinit var others : RadioButton
    private lateinit var etAddress : EditText
    private lateinit var btnAdd : Button
    private var lstStudent = ArrayList<User>()
    var count : Int = 0

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

            if(count <= 2){
                val firstName = etFirst.text.toString()
                val age = etSecond.text.toString()

                val student = User(firstName, age)
                lstStudent.add(student)

            }
            if(count == 2)
            {
                val intent = Intent(this, ChooseActivity::class.java)
                intent.putExtra("students", lstStudent)
                startActivity(intent)
            }

            count++




        }
    }
}