package com.bignerdranch.android.criminalintent.database

import androidx.room.Dao
import androidx.room.Query
import com.bignerdranch.android.criminalintent.Crime
import java.util.*

@Dao
interface CrimeDao {

    @Query("select * from crime")
    suspend fun getCrimes(): List<Crime>

    @Query("select * from crime where id=(:id)")
    suspend fun getCrime(id: UUID): Crime
}