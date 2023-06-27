package com.example.myapplication

import com.example.myapplication.Task
import com.example.myapplication.Repository

class AddTaskUseCase(private val repository: Repository) {
    fun execute(task: Task) {
        repository.createTask(task)
    }
}