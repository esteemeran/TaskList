package com.example.TaskListKotlin.domain.usecase.TaskListUseCase

import com.example.TaskListKotlin.domain.ITaskListRepository
import com.example.TaskListKotlin.domain.models.TaskList

class AddTaskListUseCase(private val taskListRepository: ITaskListRepository) {
    suspend fun execute(taskList: TaskList){
        taskListRepository.addTaskList(taskList);
    }
}