package com.sangyan.studentapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sangyan.studentapplication.StudentObject.list
import kotlinx.android.synthetic.main.student_layout.view.*

class StudentAdapter(var list : List<StudentInfo>)  : RecyclerView.Adapter<StudentAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var name = view.studentName
        var email = view.studentEmail
        var marks = view.StudentMarks
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val inflater = LayoutInflater.from(parent.context).inflate(R.layout.student_layout,parent,false)
        return ViewHolder(inflater)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.email.text = list[position].email
        holder.marks.text = list[position].marks

    }


    override fun getItemCount(): Int {
      return list.size
    }
}