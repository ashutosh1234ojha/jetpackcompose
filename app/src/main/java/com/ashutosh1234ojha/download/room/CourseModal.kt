package com.ashutosh1234ojha.download.room

import androidx.room.Entity
import androidx.room.PrimaryKey




/**
 * Created by Ashutosh Ojha on 28,March,2022
 */
@Entity(tableName = "course_table")
data class CourseModal (  @PrimaryKey(autoGenerate = true) val id:Int=0,

    // below line is a variable
    // for course name.
     val data: String? = null
)