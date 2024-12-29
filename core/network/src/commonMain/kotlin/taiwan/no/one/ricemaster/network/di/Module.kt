package taiwan.no.one.ricemaster.network.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel.ALL
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

internal val jsonProvider = module {
    single {
        Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
            encodeDefaults = false
        }
    }
}

internal val TIMEOUT = 15_000L // 15s

val networkModule = module {
    includes(jsonProvider)

    single {
        HttpClient {
            install(Logging) {
                logger = Logger.DEFAULT
                level = ALL
            }
            install(ContentNegotiation) { json(get()) }
            install(HttpCache)
            // Timeout
            install(HttpTimeout) {
                requestTimeoutMillis = TIMEOUT
                connectTimeoutMillis = TIMEOUT
                socketTimeoutMillis = TIMEOUT
            }
        }
    }
}
