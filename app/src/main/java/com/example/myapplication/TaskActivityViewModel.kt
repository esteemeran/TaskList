package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.RepositoryImpl
import com.example.myapplication.Task
import com.example.myapplication.AddTaskUseCase
import com.example.myapplication.ChangeFavoriteState
import com.example.myapplication.GetAllTaskListUseCase

class TaskActivityViewModel : ViewModel(){

    var taskList = MutableLiveData<List<Task>>()
    private val repository = RepositoryImpl
    private val getAllTaskListUseCase = GetAllTaskListUseCase(repository)
    private val changeFavoriteState = ChangeFavoriteState(repository)
    private val addTaskUseCase = AddTaskUseCase(repository)

    fun getAllTaskList() {
        taskList.value = getAllTaskListUseCase.execute()
    }

    fun addTaskList(title: String, description: String) {
        addTaskUseCase.execute(Task(title, description))
        getAllTaskList()
    }

    fun changeFavoriteState(task: Task) {
        changeFavoriteState.execute(task)
    }
}