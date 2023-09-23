package com.example.TaskListKotlin.di

import android.content.Context
import androidx.room.Room
import com.example.TaskListKotlin.data.repositoryImpl.TaskListRepository
import com.example.TaskListKotlin.data.repositoryImpl.TaskRepository
import com.example.TaskListKotlin.data.room.MyDb

object Dependencies {

    lateinit var context: Context;

    fun init(context: Context){
        this.context = context;
    }

    private val db by lazy {
        Room.databaseBuilder(context, MyDb::class.java,"task.db")
            .fallbackToDestructiveMigration()
            .createFromAsset("database/task_db.db")
            .build()
    }
    val taskListRepository by lazy {
        TaskListRepository(db.taskListDao())
    }
    val taskRepository by lazy {
        TaskRepository(db.taskDao())
    }
}