package com.example.myapplication

import com.example.myapplication.Task
import com.example.myapplication.Repository

class ChangeFavoriteState(private val repository: Repository) {
    fun execute(task: Task) {
        task.isFavorite = !task.isFavorite
        repository.updateTask(task)
    }
}