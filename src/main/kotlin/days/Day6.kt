package days

class Day6 : Day(6) {

    override fun partOne() = inputString.windowed(4).withIndex().first { it.value.toSet().size == 4 }.index + 4

    override fun partTwo() = inputString.windowed(14).withIndex().first { it.value.toSet().size == 14 }.index + 14
}
