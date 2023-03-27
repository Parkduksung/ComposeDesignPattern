package com.example.composedesignpattern.behavioral.chin_of_responsibility.coin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable


@Stable
class FiftyThousandWonDispenser : AbstractCoinDispenserChain(coinValue = 50000)

@Stable
class TenThousandWonDispenser : AbstractCoinDispenserChain(coinValue = 10000)

@Stable
class FiveThousandWonDispenser : AbstractCoinDispenserChain(coinValue = 5000)

@Stable
class ThousandWonDispenser : AbstractCoinDispenserChain(coinValue = 1000)

@Stable
class FiveHundredWonDispenser : AbstractCoinDispenserChain(coinValue = 500)

@Stable
class HundredWonDispenser : AbstractCoinDispenserChain(coinValue = 100)

@Stable
class TenWonDispenser : AbstractCoinDispenserChain(coinValue = 10)

@Stable
class OneWonDispenser : AbstractCoinDispenserChain(coinValue = 1)


@Composable
fun DisplayCoins(
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
