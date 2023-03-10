import com.oocode.*
import com.teamoptimization.ForecasterClient
import com.teamoptimization.ForecastingClient
import com.teamoptimization.LocatorClient
import java.time.DayOfWeek

fun main(args: Array<String>) {
    if (args.size != 2) {
        throw RuntimeException("Must specify Day and Place")
    }
    val forecasterClient = ForecasterClient()
    val locationClient = LocatorClient()
    val forecaster = CachingForecaster(ForecasterAdapter(forecasterClient, locationClient))
    forecast(forecaster, args[0], args[1])
    forecast(forecaster, args[0], args[1])
    forecast(forecaster, args[0], args[1])

    val forecastingClient = ForecastingClient()
    val newForecaster = CachingForecaster(ForecastingAdaptor(forecastingClient))

    forecast(newForecaster, args[0], args[1])
    forecast(newForecaster, args[0], args[1])
    forecast(newForecaster, args[0], args[1])

    val averagingForecaster = AveragingForecaster(forecaster, newForecaster)

    forecast(averagingForecaster, args[0], args[1])
    forecast(averagingForecaster, args[0], args[1])
    forecast(averagingForecaster, args[0], args[1])
}

fun forecast(forecaster: Forecaster, day: String, place: String) {
    val dayNumber = DayOfWeek.valueOf(day.uppercase()).value
    val (minTemp, maxTemp, description) = forecaster.getForecast(DayOfWeek.of(dayNumber), place)
    println("forecaster: $place day=$day min=$minTemp max=$maxTemp description=$description")
}

fun forecast2(day: String, place: String) {
    val forecasting = ForecastingClient()
    val dayOfWeek = DayOfWeek.valueOf(day.uppercase())
    val minTemp = forecasting.min(dayOfWeek, place)
    val maxTemp = forecasting.max(dayOfWeek, place)
    val description = forecasting.desc(dayOfWeek, place)
    println("forecasting: $place day=$day min=$minTemp max=$maxTemp description=$description")
}

fun moo() = "boo"
