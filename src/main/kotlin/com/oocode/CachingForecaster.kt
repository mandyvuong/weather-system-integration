package com.oocode

import java.time.DayOfWeek

class CachingForecaster(val delegate: Forecaster) : Forecaster {
    private val cache: MutableMap<Query, Forecast> = mutableMapOf()

    override fun getForecast(day: DayOfWeek, location: String): Forecast {
        val query = Query(day, location)
        return if (cache.contains(query)) {
            cache[query]!!
        } else {
            val forecast = delegate.getForecast(day, location)
            cache[query] = forecast
            forecast
        }
    }
    data class Query(val day: DayOfWeek, val location: String)
}
