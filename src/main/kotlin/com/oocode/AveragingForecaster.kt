package com.oocode

import java.time.DayOfWeek

class AveragingForecaster(val f1: Forecaster, val f2: Forecaster): Forecaster {
    override fun getForecast(day: DayOfWeek, location: String): Forecast {
        return f1.getForecast(day, location)
    }

}
