package com.example.myapplication

import com.example.myapplication.Task
import com.example.myapplication.Repository

class GetAllTaskListUseCase(private val repository: Repository) {
    fun execute() : List<Task> {
        return repository.getAllTask()
    }
}