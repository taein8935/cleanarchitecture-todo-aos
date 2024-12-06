package com.tikim.cleanarchitecturetodo.todo.domain

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
}