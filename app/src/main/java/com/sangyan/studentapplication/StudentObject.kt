package com.sangyan.studentapplication

object StudentObject {
    var list = mutableListOf<StudentInfo>()
    fun setData( name: String , email : String , marks : String) {
        list.add(StudentInfo(name, email,marks))
    }
    fun getAllData() : List<StudentInfo>{
        return  list
    }
}