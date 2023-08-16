package app.vazovsky.starwars.data.model.base

interface Progressable<T> {
    val isInProgress: Boolean

    fun updateProgress(inProgress: Boolean): T
}