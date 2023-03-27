package com.example.composedesignpattern.behavioral.chin_of_responsibility.coin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

interface CoinDispenserChain {

    val coinValue: Int

    fun setNextChain(nextChain: CoinDispenserChain)

    @Composable
    fun Dispense(currency: Currency)
}

@Stable
class HundredWonDispenser : CoinDispenserChain {

    override val coinValue: Int
        get() = 100

    private lateinit var nextChain: CoinDispenserChain

    override fun setNextChain(nextChain: CoinDispenserChain) {
        this.nextChain = nextChain
    }

    @Composable
    override fun Dispense(currency: Currency) {
        DisplayCoins(currency, coinValue) { nextAmount ->
            if (::nextChain.isInitialized) {
                nextChain.Dispense(Currency(nextAmount))
            }
        }
    }
}

@Stable
class TenWonDispenser : CoinDispenserChain {

    override val coinValue: Int
        get() = 10

    private lateinit var nextChain: CoinDispenserChain

    override fun setNextChain(nextChain: CoinDispenserChain) {
        this.nextChain = nextChain
    }

    @Composable
    override fun Dispense(currency: Currency) {
        DisplayCoins(currency, coinValue) { nextAmount ->
            if (::nextChain.isInitialized) {
                nextChain.Dispense(Currency(nextAmount))
            }
        }
    }
}

@Stable
class OneWonDispenser : CoinDispenserChain {

    override val coinValue: Int
        get() = 1

    private lateinit var nextChain: CoinDispenserChain

    override fun setNextChain(nextChain: CoinDispenserChain) {
        this.nextChain = nextChain
    }

    @Composable
    override fun Dispense(currency: Currency) {
        DisplayCoins(currency, coinValue) { nextAmount ->
            if (::nextChain.isInitialized) {
                nextChain.Dispense(Currency(nextAmount))
            }
        }
    }
}


@Composable
private fun DisplayCoins(
    currency: Currency,
    coinValue: Int,
    onRemainingAmount: @Composable (Int) -> Unit
) {

    if (currency.amount >= coinValue) {
        val numberOfCoins = currency.amount / coinValue
        val remainingAmount = currency.amount % coinValue

        CoinItemScreen(coinValue, numberOfCoins) {
            onRemainingAmount(remainingAmount)
        }
    } else {
        onRemainingAmount(currency.amount)
    }
}
