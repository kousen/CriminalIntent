package com.bignerdranch.android.criminalintent

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class DatePickerFragment : DialogFragment() {

    private val args: DatePickerFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dateListener =
            DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, month: Int, day: Int ->

                val localDate = LocalDate.of(year, month + 1, day)
                val dateTime = LocalDateTime.of(localDate, LocalTime.now())

                setFragmentResult(
                    REQUEST_KEY_DATE,
                    bundleOf(BUNDLE_KEY_DATE to dateTime)
                )
            }

        val now = args.crimeDate

        return DatePickerDialog(
            requireContext(),
            dateListener,
            now.year,
            now.monthValue - 1,
            now.dayOfMonth
        )
    }

    companion object {
        const val REQUEST_KEY_DATE = "REQUEST_KEY_DATE"
        const val BUNDLE_KEY_DATE = "BUNDLE_KEY_DATE"
    }
}