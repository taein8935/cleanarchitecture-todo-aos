package com.tikim.cleanarchitecturetodo.todo.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TodoDto(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
)
