package com.waminiyi.utility

import org.junit.Assert.assertEquals
import org.junit.Test

class MoneyUtilTest {
    @Test
    fun testConversionFromUSDtoEuro() {
        val usdAmount = 100
        val expectedEuroAmount = 94

        val actualEuroAmount = usdAmount.toEuro()

        assertEquals(expectedEuroAmount, actualEuroAmount)
    }

    @Test
    fun testConversionFromEuroToUSD() {
        val euroAmount = 100
        val expectedUSDAmount = 106
        val actualUSDAmount = euroAmount.toUSDollar()

        assertEquals(expectedUSDAmount, actualUSDAmount)
    }

    private fun removeNonBreakingSpace(input: String): String {
        return input.replace("\u00A0", " ")
    }

    @Test
    fun testFormatAsUSDollar() {
        val amount = 100
        val usdFormatted = removeNonBreakingSpace(formatAsUSDollar(amount))
        val expectedResult = "$100.00"

        assertEquals(expectedResult, usdFormatted)
    }

    @Test
    fun testFormatAsEuro() {
        val amount = 100
        val euroFormatted = removeNonBreakingSpace(formatAsEuro(amount))
        val expectedResult = "100,00 €"

        assertEquals(expectedResult, euroFormatted)
    }
}