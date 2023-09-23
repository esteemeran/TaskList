package com.example.TaskListKotlin.domain.usecase.TaskListUseCase

import com.example.TaskListKotlin.domain.ITaskListRepository
import com.example.TaskListKotlin.domain.models.TaskList

class DeleteTaskListUseCase(private val taskListRepository: ITaskListRepository) {
    suspend fun execute(taskList: TaskList){
        taskListRepository.deleteTaskList(taskList);
    }
    suspend fun execute(id: Int){
        taskListRepository.deleteTaskList(id);
    }
}