package com.oocode

import java.time.DayOfWeek

class AveragingForecaster(val f1: Forecaster, val f2: Forecaster) : Forecaster {
    override fun getForecast(day: DayOfWeek, location: String): Forecast {
        val f1Forecast = f1.getForecast(day, location)
        val f2Forecast = f2.getForecast(day, location)
        val minAverage = (f1Forecast.min + f2Forecast.min) / 2
        val maxAverage = (f1Forecast.max + f2Forecast.max) / 2

        return Forecast(min = minAverage, max = maxAverage, f1Forecast.description)
    }
}
