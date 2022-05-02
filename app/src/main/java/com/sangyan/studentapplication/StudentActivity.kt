package com.sangyan.studentapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_student.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StudentActivity : AppCompatActivity() {
    private lateinit var database :StudentDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        database = Room.databaseBuilder(
            applicationContext
            , StudentDatabase::class.java,
            "Student_Database "
        ).build()
        save.setOnClickListener {
            if (student_name.text.toString().isNotEmpty()
                && student_email.text.toString().isNotEmpty()
                && student_marks.text.toString().isNotEmpty()
            )
            {
                val name = student_name.text.toString()
                val email = student_email.text.toString()
                val marks = student_marks.text.toString()
              StudentObject.setData(name,email,marks)
              GlobalScope.launch {
                  database.studentDao().insertStudent(StudentEntity(0,name,email,marks))
              }
             val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}