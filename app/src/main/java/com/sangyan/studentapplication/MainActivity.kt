package com.sangyan.studentapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var database :StudentDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(
            applicationContext
            , StudentDatabase::class.java,
            "Student_Database "
        ).build()
        GlobalScope.launch {
            database.studentDao().getAllStudents()
        }
        floatingActionButton.setOnClickListener{
            val intent = Intent (this ,StudentActivity::class.java)
            startActivity(intent)
        }
        setRecycler()
    }

    private fun setRecycler() {
        recycler_view.adapter = StudentAdapter(StudentObject.getAllData())
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}