package taiwan.no.one.ricemaster

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform