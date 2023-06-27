package com.example.myapplication

import com.example.myapplication.Task

interface Repository {
    fun createTask(task: Task)
    fun readTask(id: Int) : Task
    fun updateTask(task: Task)
    fun deleteTask(task: Task)
    fun getAllTask() : List<Task>
}