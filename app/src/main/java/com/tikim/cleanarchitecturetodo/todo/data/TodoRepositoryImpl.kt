package com.tikim.cleanarchitecturetodo.todo.data

import com.tikim.cleanarchitecturetodo.todo.data.dto.TodoDto
import com.tikim.cleanarchitecturetodo.todo.data.mapper.toTodo
import com.tikim.cleanarchitecturetodo.todo.domain.Todo
import com.tikim.cleanarchitecturetodo.todo.domain.TodoRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class TodoRepositoryImpl(
    private val client: HttpClient
): TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        val response = client.get {
            url("https://jsonplaceholder.typicode.com/todos")
        }
        val todoList = response
            .body<List<TodoDto>>()
            .map { todoDto ->
                todoDto.toTodo()
            }

        return todoList
    }
}