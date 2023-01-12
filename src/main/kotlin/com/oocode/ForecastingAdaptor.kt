package com.oocode

import com.teamoptimization.ForecastingClient
import java.time.DayOfWeek

class ForecastingAdaptor(val forecastingClient: ForecastingClient) :Forecaster {
    override fun getForecast(day: DayOfWeek, location: String): Forecast {
        val minTemp = forecastingClient.min(day, location).toInt()
        val maxTemp = forecastingClient.max(day, location).toInt()
        val description = forecastingClient.desc(day, location)
        return Forecast(min = minTemp, max = maxTemp, description = description )
    }
}