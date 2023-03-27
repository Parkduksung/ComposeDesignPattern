package com.example.composedesignpattern.behavioral.chin_of_responsibility.coin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable



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
