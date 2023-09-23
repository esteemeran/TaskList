package com.example.TaskListKotlin.data

import com.example.TaskListKotlin.data.room.entity.TaskEntity
import com.example.TaskListKotlin.data.room.entity.TaskListEntity
import com.example.TaskListKotlin.domain.models.Task
import com.example.TaskListKotlin.domain.models.TaskList

class Mapper {
    fun taskListEntityToTaskList(taskListEntity: TaskListEntity):TaskList{
        return TaskList(taskListEntity.name,taskListEntity.isFavourite,taskListEntity.id)
    }
    fun taskListToTaskListEntity(taskList: TaskList) : TaskListEntity {
        return TaskListEntity(taskList.id, taskList.name,taskList.isFavourite)
    }

    fun taskToTaskEntity(task: Task): TaskEntity {
        return TaskEntity(task.id,task.name,task.description,task.taskListId,task.isFavourite,task.createDate)
    }
    fun taskEntityToTask(task: TaskEntity): Task {
        return Task(task.name,task.description,task.taskListId,task.isFavourite,task.id,)
    }
}