package com.bignerdranch.android.criminalintent

import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import kotlin.math.absoluteValue

fun fromLocalDateTime(date: LocalDateTime) =
    date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()

fun toLocalDateTime(epochMilli: Long): LocalDateTime =
    LocalDateTime.ofInstant(
        Instant.ofEpochMilli(epochMilli),
        ZoneId.systemDefault())

class LocalDateTimeConverterTest {

    @Test
    fun `convert LocalDateTime to Long and back`() {
        val now = LocalDateTime.now()
        println(now)
        val date = toLocalDateTime(fromLocalDateTime(now))
        println(date)
        assertTrue(date.until(now, ChronoUnit.MILLIS).absoluteValue < 0.01)
    }
}