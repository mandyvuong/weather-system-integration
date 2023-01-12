package com.oocode

import java.time.DayOfWeek

class CachingForecaster(val delegate: Forecaster) : Forecaster {
    private var cache: Forecast? = null

    override fun getForecast(day: DayOfWeek, location: String): Forecast {

        if (cache == null) { cache = delegate.getForecast(day, location) }
        return cache!!
    }
}
