package com.bignerdranch.android.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.*

private const val TAG = "CrimeListViewModel"

class CrimeListViewModel : ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        Log.d(TAG, "init starting")
        viewModelScope.launch {
            Log.d(TAG, "coroutine launched")
            crimes += loadCrimes()
            Log.d(TAG, "loading crimes finished")
        }
    }

    suspend fun loadCrimes(): List<Crime> {
        val result = mutableListOf<Crime>()
        delay(5000)
        for (i in 0 until 100) {
            val crime = Crime(
                UUID.randomUUID(),
                "Crime #$i",
                LocalDateTime.now(),
                i % 2 == 0
            )
            result += crime
        }
        return result
    }
}