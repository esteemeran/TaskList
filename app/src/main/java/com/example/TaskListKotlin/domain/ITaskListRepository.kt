package com.example.TaskListKotlin.domain

import com.example.TaskListKotlin.domain.models.TaskList

interface ITaskListRepository {
    suspend fun addTaskList(taskList: TaskList)
    suspend fun deleteTaskList(taskList: TaskList)
    suspend fun deleteTaskList(taskListId:Int)
    suspend fun updateTaskList(taskList: TaskList)
    suspend fun updateTaskList(taskListId:Int)
    suspend fun getAllTaskLists():List<TaskList>
    suspend fun getTaskList(taskListId: Int): TaskList?
}
