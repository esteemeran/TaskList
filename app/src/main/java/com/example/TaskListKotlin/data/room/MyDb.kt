package com.example.TaskListKotlin.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.TaskListKotlin.data.room.dao.TaskDao
import com.example.TaskListKotlin.data.room.dao.TaskListDao
import com.example.TaskListKotlin.data.room.entity.TaskEntity
import com.example.TaskListKotlin.data.room.entity.TaskListEntity

@Database(entities = [TaskListEntity::class, TaskEntity::class],version = 1)
abstract class MyDb : RoomDatabase() {
    abstract fun taskListDao(): TaskListDao
    abstract fun taskDao(): TaskDao

}