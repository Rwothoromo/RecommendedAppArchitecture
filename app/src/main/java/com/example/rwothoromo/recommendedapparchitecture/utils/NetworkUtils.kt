package pulse.andela.com.pulse.utils

import android.content.Context
import android.net.ConnectivityManager

fun isNetworkConnected(context: Context) : Boolean {
    val systemService = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return systemService.activeNetworkInfo?.isConnectedOrConnecting ?: false
}
