package com.example.composedesignpattern.behavioral.chin_of_responsibility.coin

import androidx.compose.runtime.Composable

class CoinDispenseManager {

    private val fiftyThousandWonDispenser = FiftyThousandWonDispenser()
    private val tenThousandWonDispenser = TenThousandWonDispenser()
    private val fiveThousandWonDispenser = FiveThousandWonDispenser()
    private val thousandWonDispenser = ThousandWonDispenser()
    private val fiveHundredWonDispenser = FiveHundredWonDispenser()
    private val hundredWonDispenser = HundredWonDispenser()
    private val tenWonDispenser = TenWonDispenser()
    private val oneWonDispenser = OneWonDispenser()

    init {
        fiftyThousandWonDispenser chainTo tenThousandWonDispenser chainTo fiveThousandWonDispenser chainTo thousandWonDispenser chainTo fiveHundredWonDispenser chainTo hundredWonDispenser chainTo tenWonDispenser chainTo oneWonDispenser
    }

    @Composable
    fun startDispensing(currency: Currency) {
        fiftyThousandWonDispenser.Dispense(currency = currency)
    }

    private infix fun AbstractCoinDispenserChain.chainTo(next: AbstractCoinDispenserChain): AbstractCoinDispenserChain {
        this.setNextChain(next)
        return next
    }

    private infix fun CoinDispenserChain.chainTo(next: CoinDispenserChain): CoinDispenserChain {
        this.setNextChain(next)
        return next
    }
}