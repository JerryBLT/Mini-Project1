package com.example.miniproject1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

// Compose UI foundational imports:
import androidx.compose.foundation.layout.* // Needed: For Column, Spacer, padding, fillMaxSize etc.
import androidx.compose.material3.* // Needed: For Material3 UI components like Text, Button
import androidx.compose.runtime.* // Needed: For Composable, remember, mutableStateOf, state handling
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign //For text align Center
import androidx.compose.ui.unit.dp // Needed: Dimension unit for padding and spacing
import androidx.compose.ui.tooling.preview.Preview
import com.example.miniproject1.ui.theme.MiniProject1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiniProject1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MessageScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MessageScreen(modifier: Modifier = Modifier) {
    var message by remember { mutableStateOf("Jerry Teixeira\njerrybt@bu.edu") }
    Column(
        modifier = Modifier
            .fillMaxSize(), // Fill entire screen
        verticalArrangement = Arrangement.Center, // Center Vertically
        horizontalAlignment = Alignment.CenterHorizontally // Center Horizontally
    ) {
        Text(
            text = message,
            textAlign = TextAlign.Center // Center text content
        )
        Spacer(modifier = Modifier.height(2.dp))
        Button(
            onClick = { message = "Message Changed Successful" } //message after clicking the 'change message' button
        ) {
            Text("Change Message")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiniProject1Theme {
        MessageScreen()
    }
}