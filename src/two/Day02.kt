package two

import readInput

fun main() {

    fun position(measurements: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0

        measurements.forEach {
            val split = it.split(" ")
            val units = split.last().toInt()
            when (split.first()) {
                "forward" -> horizontalPosition += units
                "up" -> depth -= units
                "down" -> depth += units
            }
        }
        return horizontalPosition * depth
    }

    fun positionWithAim(measurements: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0

        measurements.forEach {
            val split = it.split(" ")
            val units = split.last().toInt()
            when (split.first()) {
                "forward" -> {
                    horizontalPosition += units
                    depth += aim * units
                }
                "up" -> {
                    aim -= units
                }
                "down" -> {
                    aim += units
                }
            }
        }
        return horizontalPosition * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("/two/Day2_test")
    check(position(testInput) == 150)
    check(positionWithAim(testInput) == 900)

    val input = readInput("/two/Day2")
    println(position(input))
    println(positionWithAim(input))
}
