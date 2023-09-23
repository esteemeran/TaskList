package com.example.TaskListKotlin.domain.usecase.TaskUseCase

import com.example.TaskListKotlin.domain.ITaskRepository
import com.example.TaskListKotlin.domain.models.Task

class GetFavouriteTasksUseCase (private val taskRepository: ITaskRepository) {
    suspend fun execute():List<Task>{
        return taskRepository.getFavouriteTasks();
    }
}