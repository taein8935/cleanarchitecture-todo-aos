package com.tikim.cleanarchitecturetodo.todo.data.mapper

import com.tikim.cleanarchitecturetodo.todo.data.dto.TodoDto
import com.tikim.cleanarchitecturetodo.todo.domain.Todo

fun TodoDto.toTodo(): Todo {
    return Todo(
        id = id.toString(),
        title = title,
        completed = completed
    )
}