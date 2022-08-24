package com.bignerdranch.android.criminalintent

import java.time.LocalDateTime
import java.util.*

data class Crime(
    val id: UUID,
    val title: String,
    val date: LocalDateTime,
    val isSolved: Boolean
)