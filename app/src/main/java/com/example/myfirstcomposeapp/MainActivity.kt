package com.example.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    // Состояние для отображаемой цитаты
    var quoteText by remember { mutableStateOf("«Єдине, що постійне, – це зміни.» – Геракліт") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Основной текст
        Text(
            text = "Привіт, Світ!",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Текст цитаты
        Text(
            text = quoteText,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Кнопка для изменения цитаты
        Button(
            onClick = {
                quoteText = "«Мудрий той, хто вміє радіти тому, що має.» – Конфуцій"
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Змінити цитату")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    MyFirstComposeAppTheme {
        Content()
    }
}
