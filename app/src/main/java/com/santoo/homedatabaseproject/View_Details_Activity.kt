package com.santoo.homedatabaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santoo.homedatabaseproject.Adapter.StudentAdapter
//import com.santoo.homedatabaseproject.Adapter.StudentAdapter
import com.santoo.homedatabaseproject.database.userDB
import com.santoo.homedatabaseproject.entity.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class View_Details_Activity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view__details_)

        recyclerView = findViewById(R.id.recyclerView)
        CoroutineScope(Dispatchers.IO).launch {

            val lstStudent = userDB.getInstance(this@View_Details_Activity).getStudentDAO().getAllStudent()  //databse bata vlaue lerako

            withContext(Dispatchers.Main){
                recyclerView.adapter = StudentAdapter(lstStudent, this@View_Details_Activity)
                recyclerView.layoutManager = LinearLayoutManager(this@View_Details_Activity)
            }


        }
//

//        val adapter = StudentAdapter(lstStudent, this@View_Details_Activity )
//        recyclerView.layoutManager = LinearLayoutManager(this@View_Details_Activity)
//        recyclerView.adapter = adapter





    }

}