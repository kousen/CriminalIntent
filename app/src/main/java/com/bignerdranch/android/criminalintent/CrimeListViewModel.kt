package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import java.util.*

class CrimeListViewModel : ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        for (i in 0 until 100) {
            val crime = Crime(
                UUID.randomUUID(),
                "Crime #$i",
                LocalDateTime.now(),
                i % 2 == 0
            )

            crimes += crime
        }
    }
}