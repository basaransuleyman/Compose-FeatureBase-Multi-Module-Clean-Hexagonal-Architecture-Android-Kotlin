package com.example.detail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*The only function of this Composable class is to
functionality of the Navigation module using its own nav graph(DetailGraph) within a module.
For more understandable please check DetailScreens with DetailGraph
 */
@Composable
fun DetailSearchScreen() {
    var searchText by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        BasicTextField(
            value = searchText,
            onValueChange = { searchText = it },
            decorationBox = { innerTextField ->
                if (searchText.isEmpty()) {
                    Text("Search..")
                }
                innerTextField()
            }
        )
    }
}