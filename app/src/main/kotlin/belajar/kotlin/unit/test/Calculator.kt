package belajar.kotlin.unit.test

class Calculator {
    fun add (first: Int, second: Int): Int {
        return first + second
    }

    fun divide (first: Int, second: Int): Int {
        if (second == 0) {
            throw IllegalArgumentException("Tidak bisa dibagi 0")
        } else {
            return first / second
        }
    }
}