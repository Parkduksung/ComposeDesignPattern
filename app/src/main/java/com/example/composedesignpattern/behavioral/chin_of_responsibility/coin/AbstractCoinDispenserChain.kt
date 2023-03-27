package com.example.composedesignpattern.behavioral.chin_of_responsibility.coin

import androidx.compose.runtime.Composable

abstract class AbstractCoinDispenserChain(private val coinValue: Int) {

    private lateinit var nextChain: AbstractCoinDispenserChain

    fun setNextChain(nextChain: AbstractCoinDispenserChain) {
        this.nextChain = nextChain
    }

    @Composable
    open fun Dispense(currency: Currency) {
        DisplayCoins(currency, coinValue) { nextAmount ->
            if (::nextChain.isInitialized) {
                nextChain.Dispense(Currency(nextAmount))
            }
        }
    }
}