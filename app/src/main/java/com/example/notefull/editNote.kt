package com.example.notefull

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import java.util.UUID
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNote(noteId: String, list: MutableList<Note>, navController: NavController) {

    val note = list.firstOrNull { it.id == noteId}

    if (note != null) {
        var textTitle by remember { mutableStateOf(note.title) }
        var textBody by remember { mutableStateOf(note.body) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(value = textTitle, onValueChange = { newTextTitle ->
                textTitle = newTextTitle
                note.title = newTextTitle
            })

            TextField(value = textBody, onValueChange = { newTextBody ->
                textBody = newTextBody
                note.body = newTextBody
            })

            Row {
                Button(onClick = {
                    val noteIndex = list.indexOfFirst { it.id == noteId }
                    list[noteIndex] = note

                    navController.navigateUp()
                }) {
                    Text(text = "Save")
                }

                Button(onClick = {
                    navController.navigateUp()
                }) {
                    Text(text = "Cancel")
                }
            }
        }
    } else {
        navController.navigateUp()
    }
}
