package com.teamoptimization

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.http4k.client.OkHttp
import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request
import java.math.BigDecimal

data class Location(val lat: BigDecimal, val long: BigDecimal)

open class LocatorClient {
    private val mapper = jacksonObjectMapper()
    private val httpClient: HttpHandler = OkHttp()

    fun locationOf(locationName: String): Location {
        val response = httpClient(Request(Method.GET, "http://localhost:9231/location/$locationName"))
        return mapper.readValue(response.body.stream, Location::class.java)
    }
}