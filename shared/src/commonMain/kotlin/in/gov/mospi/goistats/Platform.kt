package in.gov.mospi.goistats

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform