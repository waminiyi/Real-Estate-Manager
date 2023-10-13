package com.waminiyi.utility

import com.waminiyi.utility.utils.currentDate
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

class DateUtilTest {
    @Test
    fun testGetCurrentDate() {
        val todayDate = LocalDate.now()
        val expectedDate = "${todayDate.dayOfMonth}/${todayDate.monthValue}/${todayDate.year}"

        assertEquals(expectedDate, currentDate)
    }
}