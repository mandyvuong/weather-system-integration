package com.oocode

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import java.time.DayOfWeek

internal class CachingForecasterTest {

    @Test
    fun `get forecast and return a forecast`() {
        val delegate = FakeForecaster()
        val forecaster = CachingForecaster(delegate)
        assertThat(forecaster.getForecast(DayOfWeek.FRIDAY, "London"), equalTo(Forecast(11, 22, "Cloudy")))
    }

    @Test
    fun `get forecast and should be able to return multiple forecast`() {
        val delegate = FakeForecaster()
        val forecaster = CachingForecaster(delegate)
        assertThat(forecaster.getForecast(DayOfWeek.FRIDAY, "London"), equalTo(Forecast(11, 22, "Cloudy")))
        assertThat(forecaster.getForecast(DayOfWeek.THURSDAY, "NY"), equalTo(Forecast(10, 12, "Snowy")))
    }
}

class FakeForecaster : Forecaster {
    override fun getForecast(day: DayOfWeek, location: String): Forecast {
        if (day == DayOfWeek.FRIDAY && location == "London") {
            return Forecast(11, 22, "Cloudy")
        } else {
            return Forecast(10, 12, "Snowy")
        }
    }

}
