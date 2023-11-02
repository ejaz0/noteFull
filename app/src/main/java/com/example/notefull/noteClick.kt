package com.example.notefull

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun noteClick(noteId: String, list: MutableList<Note>, navController: NavController) {
    val note = list.firstOrNull { it.id == noteId }

    if (note != null) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Text(
                text = note.title,
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
            )
            Text(
                text = note.body,
                modifier = Modifier.padding(16.dp),
                fontSize = 20.sp,
            )

            Button(onClick = {
                navController.navigateUp()
            }) {
                Text(text = "Back")
            }
        }
    }
}
