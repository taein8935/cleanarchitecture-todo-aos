package com.tikim.cleanarchitecturetodo.todo.presentation.todo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tikim.cleanarchitecturetodo.todo.domain.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TodoListViewModel(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val _state = MutableStateFlow(TodoListState())
    val state = _state
        .onStart {
            fetchTodos()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = _state.value
        )


    private fun fetchTodos() {
        viewModelScope.launch {
            val todos = todoRepository.getTodos()
            _state.update {
                it.copy(
                    todos = todos
                )
            }
        }
    }
}