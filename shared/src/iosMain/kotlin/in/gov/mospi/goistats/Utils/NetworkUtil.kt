package `in`.gov.mospi.goistats.Utils

import kotlinx.cinterop.*
import kotlinx.cinterop.memScoped
import platform.SystemConfiguration.*


actual class NetworkUtil {
    @OptIn(ExperimentalForeignApi::class)
    actual fun isInternetAvailable(): Boolean {
        val reachability =
            SCNetworkReachabilityCreateWithName(null, "www.google.com") ?: return false

        return memScoped {
            val flags = alloc<SCNetworkReachabilityFlagsVar>()
            if (SCNetworkReachabilityGetFlags(reachability, flags.ptr)) {
                val value = flags.value
                val isReachable = (value and kSCNetworkReachabilityFlagsReachable) != 0u
                val needsConnection =
                    (value and kSCNetworkReachabilityFlagsConnectionRequired) != 0u
                isReachable && !needsConnection
            } else {
                false
            }
        }
    }
}