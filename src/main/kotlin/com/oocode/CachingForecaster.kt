package com.oocode

import java.time.DayOfWeek

class CachingForecaster(val delegate: Forecaster) : Forecaster {
    override fun getForecast(day: DayOfWeek, location: String): Forecast {
        return delegate.getForecast(day, location)
    }
}
