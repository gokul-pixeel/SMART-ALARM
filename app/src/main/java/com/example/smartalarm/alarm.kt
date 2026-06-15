package com.example.smartalarm

data class Alarm (
        val time: String,
        val challenge: String,
        val enabled: Boolean = true
)