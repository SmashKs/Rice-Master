package taiwan.no.one.ricemaster.network.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
class NetworkModule {
    @Singleton
    fun getJson(): Json = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
        encodeDefaults = false
    }

    @Factory
    fun getHttpClient(json: Json): HttpClient = HttpClient {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }

        install(ContentNegotiation) { json(json) }

        install(HttpCache)

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
        // Timeout
        install(HttpTimeout) {
            requestTimeoutMillis = TIMEOUT
            connectTimeoutMillis = TIMEOUT
            socketTimeoutMillis = TIMEOUT
        }
    }

    companion object {
        internal const val TIMEOUT = 15_000L // 15s
    }
}
