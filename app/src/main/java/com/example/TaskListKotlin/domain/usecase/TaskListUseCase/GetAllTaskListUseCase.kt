package com.example.TaskListKotlin.domain.usecase.TaskListUseCase

import com.example.TaskListKotlin.domain.ITaskListRepository
import com.example.TaskListKotlin.domain.models.TaskList

class GetAllTaskListUseCase (private val TaskListRepository: ITaskListRepository) {
    suspend fun execute() :List<TaskList> {
        return TaskListRepository.getAllTaskLists()
    }
}