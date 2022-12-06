package days

class Day2 : Day(2) {

    override fun partOne(): Any {

        val scores = mapOf("A" to 0, "B" to 1, "C" to 2,
                           "X" to 0, "Y" to 1, "Z" to 2)
        return inputList
        .filter {
            it.isNotEmpty()
        }
        .map {
            val (a,b) = it.split(" ")
            scores[a]!! to scores[b]!!
        }
        .map { (a,b) ->             
            val s = if ((a + 1) % 3 == b) {
                6
            } else if  ((b + 1) % 3 == a) {
                0
            } else { 
                3
            }

            s + b + 1
        }
        .sum()
    }

    override fun partTwo(): Any {

        val scores = mapOf("A" to 0, "B" to 1, "C" to 2,
                           "X" to 2, "Y" to 0, "Z" to 1)

        return inputList
        .filter {
            it.isNotEmpty()
        }
        .map {
            val (a,b) = it.split(" ")
            scores[a]!! to scores[b]!!
        }
        .map { (a,b) ->          
            a to (a + b) % 3
        }
        .map { (a,b) ->             
            val s = if ((a + 1) % 3 == b) {
                6
            } else if  ((b + 1) % 3 == a) {
                0
            } else { 
                3
            }

            s + b + 1
        }
        .sum()
    }
}
