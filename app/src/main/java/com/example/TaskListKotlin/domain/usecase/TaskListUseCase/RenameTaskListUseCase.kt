package com.example.TaskListKotlin.domain.usecase.TaskListUseCase

import com.example.TaskListKotlin.domain.ITaskListRepository
import com.example.TaskListKotlin.domain.models.TaskList

class RenameTaskListUseCase (private  val repository: ITaskListRepository) {
    suspend fun execute(taskList: TaskList, newName:String){
        taskList.name = newName
        repository.updateTaskList(taskList);
    }
}