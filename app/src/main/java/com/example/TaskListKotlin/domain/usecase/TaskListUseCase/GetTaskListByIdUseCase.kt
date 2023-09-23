package com.example.TaskListKotlin.domain.usecase.TaskListUseCase

import com.example.TaskListKotlin.domain.ITaskListRepository
import com.example.TaskListKotlin.domain.models.TaskList

class GetTaskListByIdUseCase(private val taskListRepository: ITaskListRepository) {
    suspend fun execute(taskListId:Int): TaskList? {
        return taskListRepository.getTaskList(taskListId)
    }
}