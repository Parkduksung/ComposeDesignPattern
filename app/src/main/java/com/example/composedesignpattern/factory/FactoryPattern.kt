package com.example.composedesignpattern.factory

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable



@Composable
fun SampleFactory(type: SampleType) {
    type.getSampleFactory()
}

internal fun SampleType.getSampleFactory(): SampleFactory {
    return when (this) {
        SampleType.TypeA -> {
            SampleA()
        }
        SampleType.TypeB -> {
            SampleB()
        }
        SampleType.TypeC -> {
            SampleC()
        }
    }

}

interface SampleFactory {
    @Composable
    fun CreateComponent()
}


sealed class SampleType {
    object TypeA : SampleType()
    object TypeB : SampleType()
    object TypeC : SampleType()
}


@Stable
internal class SampleA : SampleFactory {

    @Composable
    override fun CreateComponent() {
        Text(text = "SampleA")
    }
}

@Stable
internal class SampleB : SampleFactory {

    @Composable
    override fun CreateComponent() {
        Text(text = "SampleB")
    }
}

@Stable
internal class SampleC : SampleFactory {

    @Composable
    override fun CreateComponent() {
        Text(text = "SampleC")
    }
}

