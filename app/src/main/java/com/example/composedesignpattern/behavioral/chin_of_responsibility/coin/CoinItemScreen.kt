package com.example.composedesignpattern.behavioral.chin_of_responsibility.coin

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun CoinItemScreen(coinValue: Int, num: Int, onFinishProgress: @Composable () -> Unit) {
    val (showProgress, setShowProgress) = remember { mutableStateOf(true) }
    val duration = 1000

    LaunchedEffect(Unit) {
        delay(duration.toLong())
        setShowProgress(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showProgress) {
            CircularProgressIndicator()
        } else {
            Text(
                text = "${coinValue}원 동전 갯수 - $num",
                modifier = Modifier
                    .height(100.dp)
                    .padding(16.dp)
            )
            onFinishProgress()
        }
    }
}
