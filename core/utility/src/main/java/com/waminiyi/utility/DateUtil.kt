package com.waminiyi.utility

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 * @return the current date in an appropriate format
 *
 */
@SuppressLint("SimpleDateFormat")
fun getCurrentDate(): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    return dateFormat.format(Date())
}