package com.sangyan.studentapplication

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Insert
    suspend fun insertStudent(entity: StudentEntity)

    @Query ("Select * from student")
    suspend fun  getAllStudents()  : List<StudentInfo>
}