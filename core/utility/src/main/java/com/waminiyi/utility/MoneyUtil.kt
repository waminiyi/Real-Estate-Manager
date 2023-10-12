package com.waminiyi.utility

import com.waminiyi.utility.CurrencyCode.EUR
import com.waminiyi.utility.CurrencyCode.USD
import java.text.NumberFormat
import java.util.*
import kotlin.math.round

/**
 * Converts numerical value from USD to EUR
 */
fun Int.toEuro(): Int = round(this * USD.rateToDollar / EUR.rateToDollar).toInt()

/**
 * Converts numerical value from EUR to USD
 */
fun Int.toUSDollar(): Int = round(this * EUR.rateToDollar).toInt()

/**
 * @return A formatted currency string representing the US Dollar
 * @param amount The amount to format
 */
fun formatAsUSDollar(amount: Int): String {
    return amount.formatCurrency(USD)
}

/**
 * @return A formatted currency string representing the Euro
 * @param amount The amount to format
 */
fun formatAsEuro(amount: Int): String {
    return amount.formatCurrency(EUR)
}

/**
 * @return A formatted currency string representing the given numeric value and currency code.
 * @param currencyCode The ISO 4217 currency code (e.g., "USD", "EUR", "GBP").
 */
private fun Int.formatCurrency(currencyCode: CurrencyCode): String {
    val locale = when (currencyCode) {
        USD -> Locale.US
        EUR -> Locale.FRANCE
    }
    val currencyInstance = Currency.getInstance(currencyCode.name)
    val format = NumberFormat.getCurrencyInstance(locale)
    format.currency = currencyInstance
    return format.format(this)
}

/**
 * Currencies Codes with their conversion rate to US Dollar
 */
enum class CurrencyCode(val rateToDollar: Float) {
    USD(1F),
    EUR(1.06F)
}