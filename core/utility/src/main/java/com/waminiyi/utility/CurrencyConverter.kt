package com.waminiyi.utility

import java.text.NumberFormat
import java.util.*
import kotlin.math.round

/**
 * Euro to US Dollar conversion rate
 */
const val EURO_TO_DOLLAR_RATE = 1.06

/**
 * US Dollar to Euro conversion rate
 */
const val DOLLAR_TO_EURO_RATE = 0.94

/**
 * US Dollar currency code
 */
const val DOLLAR_CURRENCY_CODE = "USD"

/**
 * Euro currency code
 */
const val EURO_CURRENCY_CODE = "EUR"

/**
 * Converts numerical value from USD to EUR
 */
fun Int.toEuro(): Int = round(this * DOLLAR_TO_EURO_RATE).toInt()

/**
 * Converts numerical value from EUR to USD
 */
fun Int.toUSDollar(): Int = round(this * EURO_TO_DOLLAR_RATE).toInt()

/**
 * @return A formatted currency string representing the given numeric value and currency code.
 * @param currencyCode The ISO 4217 currency code (e.g., "USD", "EUR", "GBP").
 */
fun Int.formatCurrency(currencyCode: String): String {
    try {
        val locale = if (currencyCode == DOLLAR_CURRENCY_CODE) Locale.US else Locale.FRANCE
        val currencyInstance = Currency.getInstance(currencyCode)
        val format = NumberFormat.getCurrencyInstance(locale)
        format.currency = currencyInstance
        return format.format(this)
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("Unknown currency: $currencyCode")
    }
}