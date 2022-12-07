package days

class Day4 : Day(4) {

    override fun partOne() =
        inputList.map {
            it.split(",").map { it.split("-")}
        }
        .count { l -> 
            val a = l[0][0].toInt()
            val b = l[0][1].toInt()
            val c = l[1][0].toInt()
            val d = l[1][1].toInt()
            (a <= c && b >= d) ||  (c <= a && d >= b)
        }

    override fun partTwo() = 
        inputList.map {
            it.split(",").map { it.split("-")}
        }
        .count { l -> 
            val a = l[0][0].toInt()
            val b = l[0][1].toInt()
            val c = l[1][0].toInt()
            val d = l[1][1].toInt()
            !((a..b).intersect(c..d).isEmpty())
        }
}
