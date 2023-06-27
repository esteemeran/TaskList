package com.example.myapplication

data class Task(
    var name: String,
    var description: String,
    var isFavorite: Boolean = false,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
