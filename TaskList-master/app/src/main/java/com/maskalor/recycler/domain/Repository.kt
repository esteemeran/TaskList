package com.maskalor.recycler.domain

import com.maskalor.recycler.data.Task

interface Repository {
    fun createTask(task: Task)
    fun readTask(id: Int) : Task
    fun updateTask(task: Task)
    fun deleteTask(task: Task)
    fun getAllTask() : List<Task>
}