package app.vazovsky.starwars.managers

interface Similarable<T> {
    fun areItemsTheSame(other: T): Boolean
    fun areContentsTheSame(other: T): Boolean
}