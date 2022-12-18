package days

class Day7 : Day(7) {

    private fun sizeOfPath(tree: Map<List<String>, Set<Any>>, path: List<String>): Int {
        return tree[path]!!
                .map { if (it is List<*>) sizeOfPath(tree, it as List<String>) else it as Int }
                .sum()
    }

    override fun partOne(): Int {
        var tree = mutableMapOf<List<String>, MutableSet<Any>>()

        var path = mutableListOf<String>()

        inputString.split("$ ").drop(2).map { it.trim() }.forEach {
            if (it.startsWith("cd")) {
                val targetDir = it.split(" ")[1]
                if (targetDir == "..") {
                    path.removeLast()
                } else {
                    if (!tree.containsKey(path)) {
                        tree[path.toList()] = mutableSetOf()
                    }
                    tree[path.toList()]!!.add(path + targetDir)

                    path.add(targetDir)
                }
            } else if (it.startsWith("ls")) {
                it.split("\n").drop(1).filter { !it.startsWith("dir ") }.forEach {
                    val parts = it.split(" ")

                    val size = parts[0].toInt()

                    if (!tree.containsKey(path)) {
                        tree[path.toList()] = mutableSetOf()
                    }
                    tree[path.toList()]!!.add(size)
                }
            }
        }

        return tree.map { sizeOfPath(tree, it.key) }.filter { it <= 100_000 }.sum()
    }

    override fun partTwo(): Int {
        var tree = mutableMapOf<List<String>, MutableSet<Any>>()

        var path = mutableListOf<String>()

        inputString.split("$ ").drop(2).map { it.trim() }.forEach {
            if (it.startsWith("cd")) {
                val targetDir = it.split(" ")[1]
                if (targetDir == "..") {
                    path.removeLast()
                } else {
                    if (!tree.containsKey(path)) {
                        tree[path.toList()] = mutableSetOf()
                    }
                    tree[path.toList()]!!.add(path + targetDir)

                    path.add(targetDir)
                }
            } else if (it.startsWith("ls")) {
                it.split("\n").drop(1).filter { !it.startsWith("dir ") }.forEach {
                    val parts = it.split(" ")

                    val size = parts[0].toInt()

                    if (!tree.containsKey(path)) {
                        tree[path.toList()] = mutableSetOf()
                    }
                    tree[path.toList()]!!.add(size)
                }
            }
        }

        val unusedSpace = 70000000 - sizeOfPath(tree, listOf())
        val minimalDeletedSize = 30000000 - unusedSpace
        return tree.map { sizeOfPath(tree, it.key) }.filter { it > minimalDeletedSize }.min()
    }
}
