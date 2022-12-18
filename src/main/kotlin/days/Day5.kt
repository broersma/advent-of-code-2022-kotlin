package days

import kotlin.collections.ArrayDeque

class Day5 : Day(5) {

    override fun partOne(): String {

        val input = inputString.split("\n\n")

        val stacks =
                input[0].split("\n")
                        .reversed()
                        .drop(1)
                        .map { it.drop(1).filterIndexed { i, _ -> i % 4 == 0 }.toList() }
                        .fold(Array(10) { ArrayDeque<Char>() }) { acc, row ->
                            acc.apply {
                                row.withIndex().filter { it.value.isLetter() }.onEach {
                                    acc[it.index].add(it.value)
                                }
                            }
                        }

        val proc = input[1].split("\n").map { it.split(" ").mapNotNull { it.toIntOrNull() } }

        proc.forEach {
            val num = it[0]
            val from = it[1] - 1
            val to = it[2] - 1

            repeat(num) { stacks[to].add(stacks[from].removeLast()) }
        }

        return stacks.filterNot { it.isEmpty() }.joinToString("") { it.last().toString() }
    }

    override fun partTwo(): String {

        val input = inputString.split("\n\n")

        val stacks =
                input[0].split("\n")
                        .reversed()
                        .drop(1)
                        .map { it.drop(1).filterIndexed { i, _ -> i % 4 == 0 }.toList() }
                        .fold(Array(10) { ArrayDeque<Char>() }) { acc, row ->
                            acc.apply {
                                row.withIndex().filter { it.value.isLetter() }.onEach {
                                    acc[it.index].add(it.value)
                                }
                            }
                        }

        val proc = input[1].split("\n").map { it.split(" ").mapNotNull { it.toIntOrNull() } }

        proc.forEach {
            val num = it[0]
            val from = it[1] - 1
            val to = it[2] - 1

            stacks[to].addAll(
                    sequence { repeat(num) { yield(stacks[from].removeLast()) } }
                            .toList()
                            .reversed()
            )
        }

        return stacks.filterNot { it.isEmpty() }.joinToString("") { it.last().toString() }
    }
}
