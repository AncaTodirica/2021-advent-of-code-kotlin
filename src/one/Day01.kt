package one

import readInput

fun main() {

    fun increasingMeasurements(measurements: List<String>): Int {
        return measurements
            .map { it.toInt() }
            .filterIndexed { index, value -> index > 0 && measurements[index - 1].toInt() < value }
            .size
    }

    fun increasingMeasurementsSlidingWindow(measurements: List<String>): Int {
        val windowsSums = measurements
            .map { it.toInt() }
            .windowed(3, 1)
            .map { it.sum() }

        return windowsSums
            .filterIndexed { index, value -> index > 0 && value > windowsSums[index - 1] }
            .size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("/one/Day1_Part1_test")
    check(increasingMeasurements(testInput) == 7)
    check(increasingMeasurementsSlidingWindow(testInput) == 5)

    val input = readInput("/one/Day1_Part1")
    println(increasingMeasurements(input))
    println(increasingMeasurementsSlidingWindow(input))
}
