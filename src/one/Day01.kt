package one

import readInput

fun main() {

    fun increasingMeasurements(measurements: List<String>): Int {
        var counter = measurements.size - 1
        for (index in 1 until measurements.size) {
            if (measurements[index].toInt() < measurements[index - 1].toInt()) {
                counter--
            }
        }
        return counter
    }

    fun increasingMeasurementsSlidingWindow(measurements: List<String>): Int {
        var counter = 0
        for (index in 0..measurements.size - 4) {
            val window1 =
                measurements[index].toInt() + measurements[index + 1].toInt() + measurements[index + 2].toInt()
            val window2 =
                measurements[index + 1].toInt() + measurements[index + 2].toInt() + measurements[index + 3].toInt()
            if (window2 > window1) {
                counter++
            }
        }
        return counter
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("/one/Day1_Part1_test")
    check(increasingMeasurements(testInput) == 7)
    check(increasingMeasurementsSlidingWindow(testInput) == 5)

    val input = readInput("/one/Day1_Part1")
    println(increasingMeasurements(input))
    println(increasingMeasurementsSlidingWindow(input))
}
