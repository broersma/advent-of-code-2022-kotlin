package days

import kotlin.math.absoluteValue
import kotlin.math.sign

class Day9 : Day(9) {

    private fun move(tail: Pair<Int, Int>, head: Pair<Int, Int>): Pair<Int, Int> {
        val dx = head.first - tail.first
        val dy = head.second - tail.second
        if (dx.absoluteValue > 1 || dy.absoluteValue > 1) {
            return ((tail.first + dx.sign) to (tail.second + dy.sign))
        }
        return tail
    }

    override fun partOne(): Any {
        val motions =
                inputList.map {
                    it.split(" ").let {
                        val step =
                                when (it[0]) {
                                    "U" -> (0 to -1)
                                    "D" -> (0 to +1)
                                    "L" -> (-1 to 0)
                                    "R" -> (+1 to 0)
                                    else -> error("error")
                                }

                        step to it[1].toInt()
                    }
                }

        var visited: MutableSet<Pair<Int, Int>> = mutableSetOf<Pair<Int, Int>>()

        var head = 0 to 0
        var tail = 0 to 0

        motions.forEach {
            var (dir, amount) = it
            repeat(amount) {
                head = ((head.first + dir.first) to (head.second + dir.second))

                tail = move(tail, head)

                visited.add(tail)
            }
        }

        return visited.size
    }

    override fun partTwo(): Any {
        val motions =
                inputList.map {
                    it.split(" ").let {
                        val step =
                                when (it[0]) {
                                    "U" -> (0 to -1)
                                    "D" -> (0 to +1)
                                    "L" -> (-1 to 0)
                                    "R" -> (+1 to 0)
                                    else -> error("error")
                                }

                        step to it[1].toInt()
                    }
                }

        var visited: MutableSet<Pair<Int, Int>> = mutableSetOf<Pair<Int, Int>>()

        var rope = Array<Pair<Int, Int>>(10) { 0 to 0 }

        motions.forEach {
            var (dir, amount) = it
            repeat(amount) {
                rope[0] = ((rope[0].first + dir.first) to (rope[0].second + dir.second))

                for (i in 1..9) {
                    rope[i] = move(rope[i], rope[i - 1])
                }

                visited.add(rope[9])
            }
        }

        return visited.size
    }
}
