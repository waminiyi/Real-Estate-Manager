package com.waminiyi.utility

import org.junit.Assert.assertEquals
import org.junit.Test

class IntExtensionTest {
    @Test
    fun testConversionFromUSDtoEuro() {
        val usdAmount = 100
        val expectedEuroAmount = (usdAmount * DOLLAR_TO_EURO_RATE).toInt()

        val actualEuroAmount = usdAmount.toEuro()

        assertEquals(expectedEuroAmount, actualEuroAmount)
    }

    @Test
    fun testConversionFromEuroToUSD() {
        val euroAmount = 100
        val expectedUSDAmount = (euroAmount * EURO_TO_DOLLAR_RATE).toInt()

        val actualUSDAmount = euroAmount.toUSDollar()

        assertEquals(expectedUSDAmount, actualUSDAmount)
    }

    private fun removeNonBreakingSpace(input: String): String {
        return input.replace("\u00A0", " ")
    }

    @Test
    fun testFormatCurrency() {
        val amount = 100
        val usdFormatted = removeNonBreakingSpace(amount.formatCurrency(DOLLAR_CURRENCY_CODE))
        val euroFormatted = removeNonBreakingSpace(amount.formatCurrency(EURO_CURRENCY_CODE))

        assertEquals("$100.00", usdFormatted)
        assertEquals("100,00 €", euroFormatted)
    }

    @Test
    fun testInvalidCurrencyCode() {
        val amount = 100
        val invalidCurrencyCode = "INVALID"

        try {
            amount.formatCurrency(invalidCurrencyCode)
        } catch (e: IllegalArgumentException) {
            assertEquals("Unknown currency: $invalidCurrencyCode", e.message)
        }
    }
}