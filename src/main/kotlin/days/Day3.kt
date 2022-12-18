package days

class Day3 : Day(3) {

    override fun partOne() =
            inputList
                    .map {
                        it.subSequence(0, it.length / 2) to it.subSequence(it.length / 2, it.length)
                    }
                    .map { (a, b) -> a.toSet().intersect(b.toSet()).single() }
                    .map { a -> if (a > 'a') a - 'a' + 1 else a - 'A' + 27 }
                    .sum()

    override fun partTwo() =
            inputList
                    .chunked(3)
                    .map { (a, b, c) ->
                        a.toSet().intersect(b.toSet().intersect(c.toSet())).single()
                    }
                    .map { a -> if (a > 'a') a - 'a' + 1 else a - 'A' + 27 }
                    .sum()
}
