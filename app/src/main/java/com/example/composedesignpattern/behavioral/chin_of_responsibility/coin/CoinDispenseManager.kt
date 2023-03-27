package com.example.composedesignpattern.behavioral.chin_of_responsibility.coin

import androidx.compose.runtime.Composable

class CoinDispenseManager {

    private val hundredWonDispenser = HundredWonDispenser()
    private val tenWonDispenser = TenWonDispenser()
    private val oneWonDispenser = OneWonDispenser()

    init {
        hundredWonDispenser chainTo tenWonDispenser chainTo oneWonDispenser
    }

    @Composable
    fun startDispensing(currency: Currency) {
        hundredWonDispenser.Dispense(currency = currency)
    }

    private infix fun AbstractCoinDispenserChain.chainTo(next: AbstractCoinDispenserChain): AbstractCoinDispenserChain {
        this.setNextChain(next)
        return next
    }
}