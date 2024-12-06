package com.tikim.cleanarchitecturetodo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tikim.cleanarchitecturetodo.core.data.HttpClientFactory
import com.tikim.cleanarchitecturetodo.todo.data.TodoRepositoryImpl
import com.tikim.cleanarchitecturetodo.todo.presentation.todo_list.TodoListScreenRoot
import com.tikim.cleanarchitecturetodo.todo.presentation.todo_list.TodoListViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<TodoListViewModel> {
            viewModelFactory {
                initializer {
                    TodoListViewModel(
                        todoRepository = TodoRepositoryImpl(
                            client = HttpClientFactory.create()
                        )
                    )
                }
            }
        }

        setContent {
            Scaffold(
                content = { padding ->
                    Surface(
                        modifier = Modifier.padding(padding)
                    ) {
                        TodoListScreenRoot(
                            viewModel = viewModel
                        )
                    }
                }
            )

        }
    }
}


