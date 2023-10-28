package com.example.notefull

import androidx.compose.foundation.layout.Column
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


data class Note(
    val id: String = UUID.randomUUID().toString(),
    var title: String,
    val body: String
)



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun newNote(list : MutableList<Note>, navController: NavController){

    var textTitle by rememberSaveable { mutableStateOf("") }
    var textBody by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "Enter Note")
        TextField(value = textTitle, onValueChange = { newTextTitle ->
            textTitle = newTextTitle
        })
        TextField(value = textBody, onValueChange = { newTextBody ->
            textBody = newTextBody
        })
        Button(onClick = {
            if(textTitle.length < 50 && textTitle.length > 3 && textBody.length < 120) {
                list.add(Note(title = textTitle, body = textBody))
                textTitle = ""
                textBody = ""
            }
        }) {
            Text(text = "Create")
        }

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Home")
        }
    }
}


