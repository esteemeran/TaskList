package com.example.TaskListKotlin.domain.usecase.TaskUseCase

import com.example.TaskListKotlin.domain.ITaskRepository
import com.example.TaskListKotlin.domain.models.Task

class GetTasksFromTaskListUseCase (private val taskRepository: ITaskRepository) {
    suspend fun execute(id:Int) :List<Task> {
        return taskRepository.getTasksFromTaskList(id);
    }
}