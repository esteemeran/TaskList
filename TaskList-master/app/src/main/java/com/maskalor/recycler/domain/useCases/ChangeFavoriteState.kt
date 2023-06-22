package com.maskalor.recycler.domain.useCases

import com.maskalor.recycler.data.Task
import com.maskalor.recycler.domain.Repository

class ChangeFavoriteState(private val repository: Repository) {
    fun execute(task: Task) {
        task.isFavorite = !task.isFavorite
        repository.updateTask(task)
    }
}