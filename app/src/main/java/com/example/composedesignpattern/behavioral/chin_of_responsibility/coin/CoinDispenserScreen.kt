package com.example.composedesignpattern.behavioral.chin_of_responsibility.coin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly

@Composable
fun CoinDispenserScreen() {
    val coinDispenseManager = CoinDispenseManager()

    var inputCoin by remember { mutableStateOf("") }
    var coinUiState by remember { mutableStateOf<CoinUiState>(CoinUiState.Idle) }

    Column(modifier = Modifier.fillMaxSize()) {

        OutlinedTextField(
            value = inputCoin,
            onValueChange = {
                inputCoin = it
            }, modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(16.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Search
            ),
            singleLine = true,
            label = { Text("input coin") },
            keyboardActions = KeyboardActions(
                onSearch = {
                    if (inputCoin.isDigitsOnly() && inputCoin.isNotEmpty()) coinUiState =
                        CoinUiState.Dispense(inputCoin.toInt())
                }
            )
        )


        Column(modifier = Modifier.fillMaxSize()) {
            when (val result = coinUiState) {
                is CoinUiState.Dispense -> {
                    coinDispenseManager.startDispensing(currency = Currency(result.coins))
                }
                CoinUiState.Idle -> {

                }
            }
        }
    }

}

sealed interface CoinUiState {
    object Idle : CoinUiState
    data class Dispense(val coins: Int) : CoinUiState
}
