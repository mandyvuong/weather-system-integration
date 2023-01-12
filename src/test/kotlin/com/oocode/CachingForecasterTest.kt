package com.oocode

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import java.time.DayOfWeek

internal class CachingForecasterTest {

    @Test
    fun `get forecast`() {
        val delegate = FakeForecaster()
        val forecaster = CachingForecaster(delegate)
        assertThat(forecaster.getForecast(DayOfWeek.FRIDAY, "London"), equalTo(Forecast(11, 22, "Cloudy")))
    }
}

class FakeForecaster : Forecaster {
    override fun getForecast(day: DayOfWeek, location: String): Forecast {
        return Forecast(11, 22, "Cloudy")
    }

}
