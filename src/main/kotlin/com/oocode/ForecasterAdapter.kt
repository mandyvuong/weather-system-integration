package com.oocode

import com.teamoptimization.ForecasterClient
import com.teamoptimization.LocatorClient
import java.time.DayOfWeek

class ForecasterAdapter(private val forecasterClient: ForecasterClient, private val locatorClient: LocatorClient): Forecaster {
    override fun getForecast(day: DayOfWeek, location: String): Forecast {
        val locationDegrees = locatorClient.locationOf(location)
        val forecast = forecasterClient.forecast(day.value, locationDegrees.lat, locationDegrees.long)
        return Forecast(forecast.minTemp, forecast.maxTemp, forecast.description)
    }
}