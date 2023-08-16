package app.vazovsky.starwars.managers

import javax.inject.Inject

class IdFromUrlManager @Inject constructor() {
    fun fromUrlToId(url: String): Int {
        var newUrl = url
        var indexOfLast = newUrl.indexOf('/')
        newUrl = newUrl.substring(0, indexOfLast)
        indexOfLast = newUrl.indexOf('/')
        newUrl = newUrl.substring(indexOfLast)
        return newUrl.filter { it.isDigit() }.toInt()
    }
}