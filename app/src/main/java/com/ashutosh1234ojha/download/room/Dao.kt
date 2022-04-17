package com.ashutosh1234ojha.download.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao


/**
 * Created by Ashutosh Ojha on 28,March,2022
 */
@Dao
open interface Dao {
    // below method is use to
    // add data to database.
    @Insert
    fun insert(model: CourseModal?)

    // below method is use to update
    // the data in our database.
    @Update
    fun update(model: CourseModal?)

    // below line is use to delete a
    // specific course in our database.
    @Delete
    fun delete(model: CourseModal?)

    // on below line we are making query to
    // delete all courses from our database.
    @Query("DELETE FROM course_table")
    fun deleteAllCourses()

    // below line is to read all the courses from our database.
    // in this we are ordering our courses in ascending order
    // with our course name.
    @Query("SELECT * FROM course_table ORDER BY data ASC")
    fun getAllCourses(): LiveData<List<CourseModal?>?>?
}