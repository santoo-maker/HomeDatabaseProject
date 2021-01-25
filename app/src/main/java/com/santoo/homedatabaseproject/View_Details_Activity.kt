package com.santoo.homedatabaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santoo.homedatabaseproject.entity.User

class View_Details_Activity : AppCompatActivity() {
    private var lstStudent = ArrayList<User>()
    private lateinit var recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view__details_)

//        recyclerView = findViewById(R.id.recyclerView)
//        lstStudent = intent?.getParcelableArrayListExtra<User>("students") ?:
//                throw IllegalStateException(" array list is null")

        loadUser()



//        val adapter = StudentAdapter(lstStudent, this@View_Details_Activity )
//        recyclerView.layoutManager = LinearLayoutManager(this@View_Details_Activity)
//        recyclerView.adapter = adapter





    }

    private fun loadUser() {


//        lstStudent.add(User("Santoo Shrestha", "21"))
//        lstStudent.add(User("Banin Shrestha", "28"))
//        lstStudent.add(User("Raj Shrestha", "21"))
//        lstStudent.add(User("Prince Shrestha", "21"))
//        lstStudent.add(User("Raaz Shrestha", "21"))
//
//
////        val printStream = PrintStream(
////            openFileOutput(
////                "user.txt",
////                MODE_APPEND
////            )
////        )
////           var name = lstStudent[0].firstName
////       var agee = lstStudent[1].age
////        printStream.println("$name, $agee")
//
//        println("$lstStudent")
//
    }

}