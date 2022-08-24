package com.bignerdranch.android.criminalintent

import java.net.URL

fun main() {
    println(URL("http://api.open-notify.org/astros.json").readText())
}

