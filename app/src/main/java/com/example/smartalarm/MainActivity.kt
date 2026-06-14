package com.example.smartalarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartalarm.ui.theme.SmartAlarmTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartAlarmTheme {
                HomeScreen()
                }
            }
        }
    }


@Composable
fun HomeScreen() {
    Column {
        Text(" ⏰ Smart Wake-Up Alarm")
       Card {
           Column {

               Text("7:00 am")
               Text("push ups challenge")

           }

       }

        Button(
            onClick = { }
        ) {
            Text("Add Alarm")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartAlarmTheme {
        HomeScreen()
    }
}