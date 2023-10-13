package com.waminiyi.utility

import org.junit.Test

import org.junit.Assert.assertEquals
import java.time.LocalDate

class DateUtilTest {
    @Test
    fun testGetCurrentDate() {
        val currentDate = LocalDate.now()
        val expectedDate = "${currentDate.dayOfMonth}/${currentDate.monthValue}/${currentDate.year}"

        val actualDate = getCurrentDate()

        assertEquals(expectedDate, actualDate)
    }
}