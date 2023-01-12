package com.oocode

import java.time.DayOfWeek

class CachingForecaster(val delegate: Forecaster) : Forecaster {
    var cache: Forecast? = null

    override fun getForecast(day: DayOfWeek, location: String): Forecast {

        return if (cache != null) {
            cache!!
        } else {
            cache = delegate.getForecast(day, location)
            cache!!
        }
    }
}
