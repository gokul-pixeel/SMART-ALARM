package com.example.smartalarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartalarm.ui.theme.SmartAlarmTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf

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
    var count = remember {
        mutableStateOf(0)
    }
    val alarms = listOf(
        Alarm("07:00 AM", "Push-ups"),
        Alarm("06:30 AM", "Pull-ups"),
        Alarm("08:00 AM", "Sit-ups")
    )
    Column {
        Text(" ⏰ Smart Wake-Up Alarm")
        alarms.forEach { alarm ->

            Card {
                Column {
                    Text(alarm.time)
                    Text(alarm.challenge)
                }
            }

        }
        Text("Button pressed: ${count.value} times")

        Button(
            onClick = {
                count.value++
            }
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