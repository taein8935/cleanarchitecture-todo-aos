package com.tikim.cleanarchitecturetodo.todo.presentation.todo_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tikim.cleanarchitecturetodo.todo.domain.Todo

@Composable
fun TodoList(
    todos: List<Todo>,
    modifier: Modifier = Modifier
) {

    val scrollState: LazyListState = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = scrollState,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = todos,
            key = { it.id }
        ) { todo ->
            TodoListItem(
                todo = todo,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}