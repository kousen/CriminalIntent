package com.bignerdranch.android.criminalintent

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimeBinding
import java.time.format.DateTimeFormatter

class CrimeHolder(
    private val binding: ListItemCrimeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    private val formatter = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy 'at' hh:mm a")

        fun bind(crime: Crime) {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = formatter.format(crime.date)

            binding.root.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "${crime.title} clicked!",
                    Toast.LENGTH_SHORT).show()
            }

            binding.crimeSolved.visibility = if (crime.isSolved) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
}