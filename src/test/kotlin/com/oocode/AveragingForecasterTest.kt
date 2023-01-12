package com.oocode

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import java.time.DayOfWeek

internal class AveragingForecasterTest {
    @Test
    fun `get min and max temp and return average from different forecasters`() {
        val f1 = FakeForecaster(Forecast(20, 30, "Cloudy"))
        val f2 = FakeForecaster(Forecast(10, 20, "Snowy"))
        val forecaster = AveragingForecaster(f1, f2)

        assertThat(forecaster.getForecast(DayOfWeek.FRIDAY, "London"), equalTo(Forecast(15, 25, "Cloudy")))
    }

    class FakeForecaster(val forecast: Forecast) : Forecaster {
        override fun getForecast(day: DayOfWeek, location: String): Forecast {
            return forecast
        }

    }
}