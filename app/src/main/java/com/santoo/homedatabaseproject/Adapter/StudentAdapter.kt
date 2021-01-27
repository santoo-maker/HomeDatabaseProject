package com.santoo.homedatabaseproject.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.santoo.homedatabaseproject.R
import com.santoo.homedatabaseproject.UpdateActivity
import com.santoo.homedatabaseproject.database.userDB
import com.santoo.homedatabaseproject.entity.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentAdapter(
        val lstStudent: List<Student>,
        val context: Context
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val btnDelete: ImageButton
        val btnUpdate : ImageButton
        val tvName: TextView
        val tvAge: TextView

        init {
            btnUpdate = view.findViewById(R.id.btnUpdate)
            btnDelete = view.findViewById(R.id.btnDelete)
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_details_recycler, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        var student = lstStudent[position]

        holder.tvName.text = student.fullName
        holder.tvAge.text = student.age.toString()

        holder.btnDelete.setOnClickListener {

            val builder = android.app.AlertDialog.Builder(context)
            builder.setTitle("Delete student")
            builder.setMessage("Are you sure you want to delete ${student.fullName} ??")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes") { _, _ ->
                deleteStudent(student)
            }
            builder.setNegativeButton("No") { _, _ ->
                Toast.makeText(context, "Action cancelled", Toast.LENGTH_SHORT).show()
            }
            val alertDialog: android.app.AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

        holder.btnUpdate.setOnClickListener{

            val intent = Intent(context, UpdateActivity::class.java)
            intent.putExtra("student",student)
            context.startActivity(intent)

        }
//        Glide.with(context)
//            .load(actor.actorImage)
//            .into(holder.imgProfile)
    }

    private fun deleteStudent(student: Student) {
        CoroutineScope(Dispatchers.IO).launch { userDB.getInstance(context).getStudentDAO().deleteStudent(student)
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
            }
        }

    }


    override fun getItemCount(): Int {
        return lstStudent.size
    }
}




