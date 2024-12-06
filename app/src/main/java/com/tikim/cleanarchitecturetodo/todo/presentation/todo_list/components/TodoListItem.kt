package com.tikim.cleanarchitecturetodo.todo.presentation.todo_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tikim.cleanarchitecturetodo.todo.domain.Todo
import com.tikim.cleanarchitecturetodo.core.presentation.CleanarchitecturetodoTheme

@Composable
fun TodoListItem(
    todo: Todo,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .height(IntrinsicSize.Min)
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp
            ),
        color = Color(0xFFBBDEFB),
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // ID와 완료 여부를 상단에 표시
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "ID: ${todo.id}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Text(
                    text = if (todo.completed) "Completed" else "Pending",
                    style = MaterialTheme.typography.bodySmall,
                    color = if (todo.completed) Color(0xFF2E7D32) else Color(0xFFD32F2F)
                )
            }

            // 제목 표시
            Text(
                text = todo.title,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun TodoListItemPreview() {
    CleanarchitecturetodoTheme {
        TodoListItem(
            todo = Todo(
                id = "id",
                title = "title",
                completed = false
            )
        )
    }
}
