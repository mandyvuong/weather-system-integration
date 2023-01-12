package com.oocode

import java.time.DayOfWeek

interface Forecaster {

    fun getForecast(day: DayOfWeek, location: String) : Forecast
}