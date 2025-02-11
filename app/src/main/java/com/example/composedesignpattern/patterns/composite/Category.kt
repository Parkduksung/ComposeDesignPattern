package com.example.composedesignpattern.patterns.composite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Category(
    private val children: List<CartItem> = emptyList(),
    override val name: String,
    override val price: Double = children.sumOf { it.price }
) : CartItem {

    @Composable
    override fun Render() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = name, style = MaterialTheme.typography.titleMedium)
            Column {
                children.forEach { it.Render() }
            }
        }
    }
}
