package com.sangyan.studentapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Student")
class StudentEntity (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var name : String,
    var email : String,
    var marks : String
        )