package com.bignerdranch.android.criminalintent

import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        scenario = FragmentScenario.launchInContainer(CrimeDetailFragment::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun checkCrimeFromInputFields() {
        onView(withId(R.id.crime_title))
            .perform(typeText("Sample Crime"))
        onView(withId(R.id.crime_solved))
            .perform(click())
        scenario.onFragment { fragment ->
            assertEquals("Sample Crime", fragment.crime.title)
            assertTrue(fragment.crime.isSolved)
        }
    }
}