package com.example.myfirstapp.utils

fun log(message: String) {
    println("[${Thread.currentThread().name}] $message")
}
