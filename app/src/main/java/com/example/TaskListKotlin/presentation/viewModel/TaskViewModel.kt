package com.example.TaskListKotlin.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.TaskListKotlin.di.Dependencies
import com.example.TaskListKotlin.domain.models.Task
import com.example.TaskListKotlin.domain.usecase.TaskUseCase.*
import kotlinx.coroutines.launch

class TaskViewModel: ViewModel() {
    val list = MutableLiveData<List<Task>>()
    private val taskRepository = Dependencies.taskRepository
    private val getFavouriteTasksUseCase = GetFavouriteTasksUseCase(taskRepository)
    private val getTasksFromTaskListUseCase = GetTasksFromTaskListUseCase(taskRepository)
    private val addTaskUseCase = AddTaskUseCase(taskRepository)
    private val deleteTaskFromTaskListUseCase = DeleteTaskFromTaskListUseCase(taskRepository)
    private val updateTaskUseCase = UpdateTaskUseCase(taskRepository)

    fun getTasksFromTaskList(taskListId: Int) {
        viewModelScope.launch {
            list.postValue(getTasksFromTaskListUseCase.execute(taskListId))
        }
    }
    fun getFavouriteTasks() {
        viewModelScope.launch {
            list.postValue(getFavouriteTasksUseCase.execute())
        }
    }
    fun addTask(task: Task){
        viewModelScope.launch {
            addTaskUseCase.execute(task)
        }
    }
    fun deleteTask(task: Task){
        viewModelScope.launch {
            deleteTaskFromTaskListUseCase.execute(task)
        }
    }
    fun updateTask(task:Task){
        viewModelScope.launch {
            updateTaskUseCase.execute(task)
        }
    }

}