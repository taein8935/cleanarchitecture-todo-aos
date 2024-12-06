package com.tikim.cleanarchitecturetodo.todo.presentation.todo_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tikim.cleanarchitecturetodo.todo.presentation.todo_list.components.TodoList

@Composable
fun TodoListScreenRoot(
    viewModel: TodoListViewModel
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    
    TodoListScreen(
        state = state
    )

}

@Composable
fun TodoListScreen(
    state: TodoListState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        TodoList(
            todos = state.todos
        )
    }
}