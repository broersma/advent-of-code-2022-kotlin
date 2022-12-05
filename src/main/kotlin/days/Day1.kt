package days

class Day1 : Day(1) {

    override fun partOne(): Any {
        return inputList.fold(mutableListOf(mutableListOf<String>())) { acc, item-> 
            if (item.isEmpty()) {
                acc.add(mutableListOf())
            } else {
                acc.last().add(item)
            }
            acc
        }.map {
            it.map{ it.toInt() }.sum()
        }.max()
    }

    override fun partTwo(): Any {
        return inputList.fold(mutableListOf(mutableListOf<String>())) { acc, item-> 
            if (item.isEmpty()) {
                acc.add(mutableListOf())
            } else {
                acc.last().add(item)
            }
            acc
        }.map {
            it.map{ it.toInt() }.sum()
        }.sorted().reversed().take(3).sum()
    }
}
