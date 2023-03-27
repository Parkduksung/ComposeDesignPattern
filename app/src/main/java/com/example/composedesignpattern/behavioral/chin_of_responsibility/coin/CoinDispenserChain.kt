package com.example.composedesignpattern.behavioral.chin_of_responsibility.coin

import androidx.compose.runtime.Composable


interface CoinDispenserChain {

    val coinValue: Int

    fun setNextChain(nextChain: CoinDispenserChain)

    @Composable
    fun Dispense(currency: Currency)
}
