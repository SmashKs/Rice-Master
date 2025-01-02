package taiwan.no.one.ricemaster.di

internal expect class PlatformModule {
    fun getWebClientId(): String
}
