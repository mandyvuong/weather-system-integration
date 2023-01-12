package com.oocode

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import java.time.DayOfWeek

internal class AveragingForecasterTest {
    @Test
    fun `get min and max temp and return average`() {
        val f1 = FakeForecaster()
        val f2 = FakeForecaster()
        val forecaster = AveragingForecaster(f1, f2)
        
        assertThat(forecaster.getForecast(DayOfWeek.FRIDAY, "London"), equalTo(Forecast(11, 22, "Cloudy")))
    }

}