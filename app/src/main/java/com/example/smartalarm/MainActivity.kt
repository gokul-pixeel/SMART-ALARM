package com.example.smartalarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartalarm.ui.theme.SmartAlarmTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.TextField
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.unit.dp


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
    var timeInput = remember {
        mutableStateOf("")
    }
    var challengeInput = remember {
        mutableStateOf("")
    }
    val alarms = remember {
        mutableStateListOf(
            Alarm("07:00 AM", "Push-ups"),
            Alarm("06:30 AM", "Pull-ups"),
            Alarm("08:00 AM", "Sit-ups")
        )
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    )  {
        Text(" ⏰ Smart Wake-Up Alarm")
        TextField(
            value=timeInput.value,
            onValueChange = {
                timeInput.value = it
            },
            label = {
                Text("alarm Time")
            }
        )
        alarms.forEach { alarm ->

            Card {
                Column {
                    Text(alarm.time)
                    Text(alarm.challenge)
                    Button(
                        onClick = {
                            alarms.remove(alarm)
                        }
                    ) {
                        Text("Delete")
                    }
                }
            }

        }
        TextField(
            value = challengeInput.value,
            onValueChange = {
                challengeInput.value = it
            },
            label = {
                Text("Challenge")
            }
        )


        Button(
            onClick = {
                alarms.add(
                    Alarm(
                        timeInput.value,
                        challengeInput.value
                    )
                )

                timeInput.value = ""
                challengeInput.value = ""
            }

        )
        {
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