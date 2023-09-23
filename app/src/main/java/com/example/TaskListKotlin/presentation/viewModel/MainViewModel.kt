package com.example.TaskListKotlin.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.TaskListKotlin.di.Dependencies
import com.example.TaskListKotlin.domain.models.TaskList
import com.example.TaskListKotlin.domain.usecase.TaskListUseCase.*
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {


    val taskLists = MutableLiveData<List<TaskList>>()
    private val taskListRepository = Dependencies.taskListRepository
    private val addTaskListUseCase = AddTaskListUseCase(taskListRepository)
    private val getAllTaskListUseCase = GetAllTaskListUseCase(taskListRepository)
    private val deleteTaskListUseCase = DeleteTaskListUseCase(taskListRepository)
    private val renameTaskListUseCase = RenameTaskListUseCase(taskListRepository)

    fun addTaskList(taskList: TaskList){
        viewModelScope.launch {
            addTaskListUseCase.execute(taskList);
            getAllTaskList()
        }
    }
    fun renameTaskList(name: String,taskList: TaskList){
        viewModelScope.launch {
            renameTaskListUseCase.execute(taskList,name)
            getAllTaskList()
        }
    }
    fun getAllTaskList(){
        viewModelScope.launch {
            taskLists.postValue(getAllTaskListUseCase.execute())
        }
    }
    fun removeTaskList(taskListId: Int){
        viewModelScope.launch {
            deleteTaskListUseCase.execute(taskListId)
            getAllTaskList()
        }

    }

}