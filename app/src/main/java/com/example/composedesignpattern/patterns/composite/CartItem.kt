package com.example.composedesignpattern.patterns.composite

import androidx.compose.runtime.Composable

interface CartItem {
    val name: String
    val price: Double

    @Composable
    fun Render()
}