package com.bignerdranch.android.criminalintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.*

@Entity
data class Crime(
    @PrimaryKey
    val id: UUID,
    val title: String,
    val date: LocalDateTime,
    val isSolved: Boolean
)