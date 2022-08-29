package com.bignerdranch.android.criminalintent.database

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class CrimeTypeConverters {
    @TypeConverter
    fun fromLocalDateTime(date: LocalDateTime) =
        date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()

    @TypeConverter
    fun toLocalDateTime(epochMilli: Long): LocalDateTime =
        LocalDateTime.ofInstant(
            Instant.ofEpochMilli(epochMilli),
            ZoneId.systemDefault())
}