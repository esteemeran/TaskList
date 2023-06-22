package com.maskalor.recycler.domain.useCases

import com.maskalor.recycler.data.Task
import com.maskalor.recycler.domain.Repository

class GetAllTaskListUseCase(private val repository: Repository) {
    fun execute() : List<Task> {
        return repository.getAllTask()
    }
}