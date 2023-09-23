package com.example.TaskListKotlin.domain.usecase.TaskUseCase

import com.example.TaskListKotlin.domain.ITaskRepository
import com.example.TaskListKotlin.domain.models.Task

class AddTaskUseCase (private val taskRepository: ITaskRepository) {
    suspend fun execute(task: Task){
        taskRepository.addTask(task);
    }
}