package com.tikim.cleanarchitecturetodo.todo.presentation.todo_list

import com.tikim.cleanarchitecturetodo.todo.domain.Todo

data class TodoListState(
    val todos: List<Todo> = emptyList()
)