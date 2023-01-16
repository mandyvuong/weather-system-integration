# weather-system-integration
Workshop on system integration 

## Weather Client
You are given client code that can connect to a remote weather service and retrieve data given a location (as latitude and longitude) and a day of the week, and also client code for a service that returns the latitude and longitude given a place name. The “main” method defined in Main.kt shows you how to use these.

## Exercise 
- [x] 1 - Build a client that caches the forecasts from ForecasterClient in memory to speed up subsequent lookups.

- [x] 2 - Another forecasting client becomes available - add caching for using that forecaster too. To get this new forecaster, execute “git merge extension” and you will see the class ForecastingClient and a new method in Main.kt called forecast2 which you can add to the main function.

- [x] 3 - Allow averaging of the min and max from both forecasting clients. (Description from either)

- [ ] 4 - Add the ability to set a limit for the size of the cache, evicting old entries if the maximum size is reached.
- [ ] 5 - Data should be cached for up to one hour, after which time it should be refreshed.
