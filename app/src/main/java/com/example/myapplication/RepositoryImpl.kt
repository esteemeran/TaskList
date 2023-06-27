package com.example.myapplication

import com.example.myapplication.Repository

object RepositoryImpl : Repository {

    private val taskList = mutableListOf<Task>()

    private var autoIncrement = 0

    init {
        for (i in 0..5) {
            val task = Task("Task № ${i}", "Description № ${i}")
            createTask(task)
        }
    }

    override fun createTask(task: Task) {
        if (task.id == Task.UNDEFINED_ID) {
            task.id = autoIncrement++
        }
        taskList.add(task)
    }

    override fun deleteTask(task: Task){
        taskList.remove(task)
    }

    override fun updateTask(task: Task) {
        val oldTask = taskList.find {
            it.id == task.id
        }
        taskList.remove(oldTask)
        taskList.add(task.id, task)
    }


    override fun readTask(id: Int): Task {
        return taskList.find {
            it.id == id
        }!!
    }

    override fun getAllTask(): List<Task> {
        return taskList.toList()
    }
}