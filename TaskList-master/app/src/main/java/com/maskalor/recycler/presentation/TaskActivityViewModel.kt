package com.maskalor.recycler.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maskalor.recycler.data.RepositoryImpl
import com.maskalor.recycler.data.Task
import com.maskalor.recycler.domain.useCases.AddTaskUseCase
import com.maskalor.recycler.domain.useCases.ChangeFavoriteState
import com.maskalor.recycler.domain.useCases.GetAllTaskListUseCase

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