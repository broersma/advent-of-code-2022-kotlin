package days

class Day8 : Day(8) {

    override fun partOne() : Int {

        val height = inputList.size
        val width = inputList[0].length
        val map = Array(height) { IntArray(width) }
        for (y in 0..height-1) {
            for (x in 0..width-1) {
                map[y][x] = inputList[y][x].digitToInt()
            }
        }

        val visible = Array(height) { IntArray(width) }
        for (y in 0..height-1) {
            for (x in 0..width-1) {
                search@ for (d in listOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)) {
                    var dx = x
                    var dy = y
                    while(true) {
                        dx += d.first
                        dy += d.second

                        if ( !(dx in 0..width-1 && dy in 0..height-1) ) {
                            visible[y][x] = 1
                            break@search
                        }

                        if ( map[dy][dx] >= map[y][x] ) {
                            break
                        }
                    }
                }
            }
        }

        return visible.map { it.sum() }.sum()
    }

    override fun partTwo() : Int {

        val height = inputList.size
        val width = inputList[0].length
        val map = Array(height) { IntArray(width) }
        for (y in 0..height-1) {
            for (x in 0..width-1) {
                map[y][x] = inputList[y][x].digitToInt()
            }
        }

        val score = Array(height) { IntArray(width) }
        for (y in 0..height-1) {
            for (x in 0..width-1) {
                score[y][x] = 1
                for (d in listOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)) {
                    var dx = x
                    var dy = y
                    var dirScore = 0
                    while(true) {
                        dx += d.first
                        dy += d.second

                        if ( dx in 0..width-1 && dy in 0..height-1 ) {
                            dirScore += 1
                            if ( map[dy][dx] >= map[y][x]) {
                                break
                            }
                        } else {                            
                            break
                        }
                    }
                    score[y][x] *= dirScore
                }
            }
        }

        return score.map { it.max() }.max()
    }
}