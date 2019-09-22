package com.example.hackathon2019summer.cash_back

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

data class CreditCardData(
    val company: String,
    val name: String,
    val category: String,
    val brand: String,
    val fragmentManager: FragmentManager
)