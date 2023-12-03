enum class CubeColor {
    BLUE, RED, GREEN;

    companion object {
        fun fromValue(value: String): CubeColor = when (value) {
            BLUE.name.lowercase() -> BLUE
            RED.name.lowercase() -> RED
            GREEN.name.lowercase() -> GREEN
            else -> throw IllegalArgumentException("Not a valid color")
        }
    }
}

data class Turn(
    val greens: Int = 0,
    val blues: Int = 0,
    val reds: Int = 0
)

data class Game(
    val id: Int,
    val turns: List<Turn>
)

fun parseTurns(input: String): List<Turn> {
    return input.split(";")
        .map { turn ->
            val cubes = turn
                .split(",")
                .associate {
                    val split = it.trim().split(" ")
                    CubeColor.fromValue(split[1]) to split[0].toInt()
                }

            Turn(
                greens = cubes[CubeColor.GREEN] ?: 0,
                blues = cubes[CubeColor.BLUE] ?: 0,
                reds = cubes[CubeColor.RED] ?: 0,
            )
        }
}

fun parseGame(input: String): Game {
    val splitInputs = input.split(":")

    return Game(
        splitInputs[0].split(" ")[1].toInt(),
        parseTurns(splitInputs[1])
    )
}

fun Game.isValid() : Boolean {
    turns.forEach {turn ->
        if (turn.blues > 14 || turn.greens > 13 || turn.reds > 12) return false
    }

    return true
}

fun Game.calculateMinCubesPower() : Int {
    val map = mutableMapOf<CubeColor, Int>(
        CubeColor.GREEN to 0,
        CubeColor.BLUE to 0,
        CubeColor.RED to 0,
    )

    turns.forEach {
        if (it.blues > map[CubeColor.BLUE]!!) map[CubeColor.BLUE] = it.blues
        if (it.greens > map[CubeColor.GREEN]!!) map[CubeColor.GREEN] = it.greens
        if (it.reds > map[CubeColor.RED]!!) map[CubeColor.RED] = it.reds
    }

    return map[CubeColor.BLUE]!! * map[CubeColor.GREEN]!! * map[CubeColor.RED]!!
}

fun solvePuzzle(input: String): Int {
    val powerOfCubes = input
        .split("\n")
        .filter { it.isNotEmpty() }
        .map { parseGame(it) }
        .map { it.calculateMinCubesPower() }

    return powerOfCubes.sumOf { it }
}

//val testCase = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
//        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" +
//        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" +
//        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" +
//        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green\n"
//
//solvePuzzle(testCase)

val testCase = "Game 1: 10 red, 7 green, 3 blue; 5 blue, 3 red, 10 green; 4 blue, 14 green, 7 red; 1 red, 11 green; 6 blue, 17 green, 15 red; 18 green, 7 red, 5 blue\n" +
        "Game 2: 13 green, 10 red; 11 green, 1 blue, 7 red; 5 red, 12 green, 1 blue; 12 green, 6 red; 8 green, 5 red; 12 green, 1 red\n" +
        "Game 3: 7 green, 1 blue; 1 blue, 3 green, 1 red; 1 green, 1 blue; 2 green; 1 blue, 7 green, 2 red; 2 green\n" +
        "Game 4: 7 green, 11 blue; 12 blue, 7 green; 1 green, 7 blue; 5 blue, 2 green; 5 red, 9 green, 14 blue\n" +
        "Game 5: 2 red, 6 blue, 6 green; 2 red, 6 green; 12 blue, 5 red, 3 green; 12 green, 5 red, 8 blue; 10 blue, 5 green; 2 red, 4 green\n" +
        "Game 6: 8 blue, 1 red, 17 green; 7 blue; 10 green, 6 blue; 5 blue, 1 red, 11 green\n" +
        "Game 7: 1 blue, 2 red, 2 green; 1 blue, 3 green; 3 green, 1 red, 3 blue; 2 blue, 3 green, 1 red\n" +
        "Game 8: 3 green, 10 red, 15 blue; 1 green, 9 red; 9 blue, 2 green, 12 red\n" +
        "Game 9: 4 green, 10 blue, 13 red; 16 red, 7 blue; 14 red, 1 green, 1 blue; 14 red, 4 blue, 1 green\n" +
        "Game 10: 6 blue, 9 red, 3 green; 9 green, 7 blue, 9 red; 2 red, 4 blue, 6 green; 12 green, 7 blue, 5 red\n" +
        "Game 11: 1 green, 6 blue, 6 red; 7 red, 1 blue; 1 green, 6 blue; 4 red, 1 green, 1 blue; 6 red, 9 green, 4 blue; 5 green, 7 red, 4 blue\n" +
        "Game 12: 18 green, 4 red, 12 blue; 7 green, 5 blue, 3 red; 7 green, 3 red; 8 green, 7 blue; 4 red, 7 green, 10 blue\n" +
        "Game 13: 1 red, 2 blue; 1 red, 6 green; 5 blue, 2 red, 12 green; 1 red, 11 green, 2 blue; 2 red, 8 green, 1 blue; 3 blue, 16 green, 1 red\n" +
        "Game 14: 3 blue, 2 green; 4 green, 1 red; 1 green, 1 red, 3 blue; 4 blue, 3 green; 5 blue, 1 green; 4 green, 2 blue, 1 red\n" +
        "Game 15: 12 blue, 3 red; 5 blue, 2 red, 1 green; 12 blue, 3 red, 2 green; 1 green, 5 red, 6 blue; 1 green, 5 blue, 3 red\n" +
        "Game 16: 8 red, 4 blue, 1 green; 15 blue, 5 red, 4 green; 3 green, 13 blue, 4 red; 4 red, 1 blue, 3 green; 1 green, 13 blue, 6 red\n" +
        "Game 17: 8 red, 7 green, 2 blue; 6 green, 1 blue, 12 red; 3 red; 4 green, 1 red; 7 red, 1 blue, 9 green\n" +
        "Game 18: 7 blue, 10 red, 3 green; 3 green, 1 blue; 7 red, 1 green, 7 blue; 7 blue, 4 red, 1 green; 2 green, 1 blue, 10 red; 3 blue, 11 red, 1 green\n" +
        "Game 19: 10 red, 10 blue; 13 red; 4 blue, 15 red, 3 green; 6 green, 11 red, 11 blue; 4 blue, 8 red\n" +
        "Game 20: 1 blue, 9 green, 2 red; 2 blue, 4 red, 4 green; 4 green, 2 red\n" +
        "Game 21: 13 green, 1 red; 3 red, 5 green, 11 blue; 1 blue, 2 red, 4 green; 7 blue, 3 red; 2 red, 1 blue, 3 green\n" +
        "Game 22: 2 red, 2 blue, 3 green; 10 red, 4 blue; 8 blue, 8 green, 11 red\n" +
        "Game 23: 1 red, 2 blue; 1 blue, 1 green; 1 green; 3 red, 1 blue, 1 green\n" +
        "Game 24: 12 green, 4 red, 2 blue; 8 green, 5 blue; 8 green, 2 blue, 2 red\n" +
        "Game 25: 3 red, 8 green; 1 red, 4 blue, 1 green; 6 green; 3 blue, 5 green, 3 red; 9 green, 3 blue, 5 red\n" +
        "Game 26: 1 green, 3 red, 2 blue; 7 red, 2 green, 11 blue; 7 blue, 4 red; 11 blue, 1 red, 1 green; 2 green, 10 blue, 1 red; 1 green, 7 red, 7 blue\n" +
        "Game 27: 5 green, 2 red, 4 blue; 5 red, 4 blue, 3 green; 5 green, 2 red, 7 blue; 7 red, 15 green, 5 blue\n" +
        "Game 28: 1 green, 7 blue, 14 red; 7 green, 6 blue, 3 red; 7 blue, 4 red, 10 green; 9 red, 11 green, 5 blue\n" +
        "Game 29: 4 red, 6 blue, 5 green; 12 red, 3 green, 1 blue; 6 blue, 11 red, 6 green; 2 green, 2 blue, 12 red\n" +
        "Game 30: 13 green, 11 red, 11 blue; 7 green, 9 blue, 7 red; 11 red, 1 blue, 11 green\n" +
        "Game 31: 14 green, 1 blue, 8 red; 1 green, 2 blue; 1 green, 1 red, 1 blue\n" +
        "Game 32: 7 blue, 2 green; 12 blue, 7 green; 4 red, 14 blue, 2 green; 14 green, 4 blue\n" +
        "Game 33: 5 blue, 12 red; 3 blue, 4 red, 1 green; 9 red, 2 blue; 11 red\n" +
        "Game 34: 1 blue; 3 blue; 1 blue, 1 red; 5 red, 2 blue; 4 red, 1 blue, 1 green\n" +
        "Game 35: 3 green, 2 blue, 1 red; 2 red, 8 green, 3 blue; 7 green, 2 red, 8 blue; 3 blue, 4 green\n" +
        "Game 36: 10 green, 9 blue, 2 red; 3 green, 7 blue, 7 red; 14 green, 13 blue; 8 green, 8 red, 2 blue\n" +
        "Game 37: 3 red, 1 blue, 14 green; 1 blue, 1 green; 5 red, 9 green; 1 red, 2 blue, 13 green; 11 red, 14 green, 2 blue\n" +
        "Game 38: 4 green, 3 red, 6 blue; 18 red, 15 blue, 1 green; 17 blue, 6 green, 19 red; 18 red, 15 blue; 1 green, 12 blue, 18 red\n" +
        "Game 39: 1 red; 10 blue, 6 red, 1 green; 1 green, 1 red, 9 blue; 17 red, 10 blue\n" +
        "Game 40: 5 red, 3 green, 9 blue; 8 red, 4 blue; 2 green, 3 blue, 4 red; 3 blue, 4 red, 6 green; 4 blue, 5 red, 2 green; 4 blue\n" +
        "Game 41: 6 green, 1 blue; 5 blue, 3 green, 6 red; 10 red, 1 blue; 6 green, 1 blue, 9 red\n" +
        "Game 42: 1 red, 5 green, 7 blue; 7 red, 4 blue, 4 green; 5 red, 2 green, 6 blue\n" +
        "Game 43: 1 green, 18 red, 8 blue; 7 red, 4 green, 5 blue; 1 blue, 18 red; 5 red, 8 blue\n" +
        "Game 44: 3 blue, 10 green; 5 green, 2 red, 1 blue; 6 blue, 14 green; 3 green, 5 blue, 5 red\n" +
        "Game 45: 12 red, 1 blue, 16 green; 1 red, 6 blue, 3 green; 5 red, 5 blue, 7 green; 8 red, 15 green; 3 green, 12 red, 7 blue\n" +
        "Game 46: 3 red, 1 green; 1 green, 17 blue, 10 red; 2 green, 17 blue; 3 green, 17 blue, 12 red; 2 green, 12 red\n" +
        "Game 47: 3 green, 9 red; 3 red, 1 blue, 6 green; 10 red, 9 green, 1 blue; 2 blue, 15 green; 7 red, 12 green, 3 blue\n" +
        "Game 48: 4 green, 13 red, 14 blue; 8 red, 8 green; 15 blue, 4 red, 11 green; 3 blue, 3 red, 4 green; 2 blue, 6 red, 4 green; 13 green, 12 blue, 11 red\n" +
        "Game 49: 15 blue, 2 green, 7 red; 1 green, 7 red, 7 blue; 13 blue; 3 blue, 2 red, 1 green\n" +
        "Game 50: 9 red; 5 green, 2 blue, 10 red; 5 red, 1 green\n" +
        "Game 51: 3 green, 1 blue, 3 red; 4 blue, 4 red; 4 green, 6 red, 5 blue; 4 red, 7 blue\n" +
        "Game 52: 10 green, 12 red, 2 blue; 2 green, 7 red; 18 green, 3 red, 3 blue; 6 red, 13 green, 2 blue\n" +
        "Game 53: 13 blue, 2 green; 2 green, 12 blue; 1 green, 11 blue, 1 red; 11 blue, 2 green, 8 red\n" +
        "Game 54: 5 red; 15 green, 17 red, 7 blue; 14 green, 5 red, 15 blue; 2 red, 10 blue, 16 green\n" +
        "Game 55: 1 blue, 1 red, 2 green; 5 green, 3 blue, 8 red; 6 red, 4 blue, 7 green; 2 blue, 10 green, 7 red\n" +
        "Game 56: 1 blue, 8 red, 7 green; 3 green, 7 blue, 5 red; 5 green, 7 blue; 3 blue, 12 red, 8 green; 3 blue; 2 blue, 3 green, 10 red\n" +
        "Game 57: 5 red, 13 green, 3 blue; 19 green, 7 red, 8 blue; 1 red, 12 green, 3 blue; 4 green, 10 blue, 4 red; 3 blue, 7 red, 20 green\n" +
        "Game 58: 8 blue, 5 red, 2 green; 4 red, 11 blue; 9 blue, 6 green, 8 red; 7 green, 11 blue\n" +
        "Game 59: 7 red, 7 green, 9 blue; 5 red, 4 green, 5 blue; 1 red, 2 blue, 6 green; 10 green, 12 blue, 3 red; 7 green, 18 blue, 4 red\n" +
        "Game 60: 12 blue, 7 red, 12 green; 18 green, 9 red; 13 green, 13 red, 12 blue; 14 red, 5 green, 13 blue; 17 green, 7 red, 13 blue\n" +
        "Game 61: 5 blue; 2 blue, 10 green, 2 red; 12 green, 2 red, 1 blue; 4 blue, 2 green; 2 red, 6 green; 6 green, 2 blue, 2 red\n" +
        "Game 62: 2 blue, 5 red, 4 green; 3 green, 6 blue, 7 red; 13 red, 5 blue, 1 green; 3 red, 3 blue, 1 green; 17 blue, 4 green, 3 red; 5 red, 13 blue, 3 green\n" +
        "Game 63: 1 red, 6 blue, 10 green; 1 red, 8 blue, 6 green; 7 red, 11 blue\n" +
        "Game 64: 11 blue, 13 red; 12 blue, 6 red; 1 green, 2 blue, 4 red\n" +
        "Game 65: 1 green, 9 red, 4 blue; 11 blue, 3 green; 2 blue, 1 green; 3 red, 2 green, 10 blue\n" +
        "Game 66: 8 red, 1 blue, 3 green; 1 green, 3 blue, 1 red; 2 blue, 9 green; 8 green, 3 blue, 6 red; 2 blue, 12 green, 7 red\n" +
        "Game 67: 5 green, 5 red, 10 blue; 12 blue, 13 green, 4 red; 6 red, 11 green, 3 blue; 8 blue, 4 red; 4 red, 14 green; 1 red, 1 blue, 14 green\n" +
        "Game 68: 7 green, 17 red; 14 green, 1 blue, 1 red; 11 green, 1 blue, 16 red\n" +
        "Game 69: 11 red, 2 green, 2 blue; 4 blue, 14 red; 2 red, 6 blue, 3 green; 6 red, 2 green; 5 red, 1 green, 4 blue; 7 red, 3 blue\n" +
        "Game 70: 18 blue, 4 red; 5 red, 14 blue; 17 blue, 9 red; 13 red, 17 blue, 1 green; 2 blue, 9 red\n" +
        "Game 71: 1 green, 6 red, 6 blue; 6 green, 4 blue, 5 red; 8 red, 3 blue, 7 green; 7 red, 2 blue, 1 green; 3 blue, 2 green, 3 red\n" +
        "Game 72: 11 green, 4 red, 2 blue; 2 blue, 6 green, 1 red; 3 red, 1 blue, 9 green; 4 blue, 12 green, 3 red; 2 red, 3 green, 1 blue\n" +
        "Game 73: 1 blue, 12 red; 14 green, 2 blue, 10 red; 6 blue, 8 red, 8 green; 7 green; 6 red, 10 green, 4 blue; 4 green, 9 red\n" +
        "Game 74: 5 green, 6 blue; 1 green, 12 blue; 2 blue, 2 green, 5 red; 5 green, 9 blue, 2 red\n" +
        "Game 75: 11 red, 7 blue, 12 green; 7 blue, 8 red, 9 green; 3 red, 17 green, 3 blue\n" +
        "Game 76: 1 green, 12 blue; 11 blue, 7 green, 10 red; 10 green, 12 blue, 1 red; 10 green, 12 red, 1 blue\n" +
        "Game 77: 2 blue, 17 green, 3 red; 10 red, 13 green; 12 green, 2 blue, 13 red; 12 green, 2 blue, 8 red; 14 green, 10 red, 1 blue\n" +
        "Game 78: 3 red, 8 green, 5 blue; 8 green, 3 blue; 2 green, 6 red; 4 red, 1 green, 4 blue; 4 red, 8 green, 6 blue; 1 red, 1 blue, 8 green\n" +
        "Game 79: 1 green, 2 blue, 2 red; 1 blue, 19 red, 1 green; 18 red; 1 green, 3 red, 5 blue; 15 red, 1 blue; 2 blue, 17 red, 1 green\n" +
        "Game 80: 13 red, 1 green; 15 red, 1 blue; 8 red, 1 green\n" +
        "Game 81: 1 blue, 1 red, 2 green; 1 red, 3 green, 2 blue; 1 blue, 4 green; 2 green, 2 blue\n" +
        "Game 82: 8 red, 4 green, 8 blue; 4 green, 6 red, 3 blue; 3 red, 3 blue; 2 blue, 1 green, 11 red; 2 green, 1 blue, 4 red\n" +
        "Game 83: 1 red, 15 green; 2 red, 6 blue, 12 green; 3 green, 10 blue, 14 red; 6 blue, 7 red, 1 green\n" +
        "Game 84: 2 blue, 12 red, 4 green; 1 red, 3 blue, 5 green; 6 blue, 5 green, 12 red; 2 red, 1 green; 2 red, 5 blue, 5 green\n" +
        "Game 85: 4 red; 3 red, 15 green, 2 blue; 15 green, 1 red, 2 blue; 4 green, 4 red, 2 blue\n" +
        "Game 86: 1 green, 3 red, 4 blue; 2 green, 7 red, 4 blue; 7 red, 4 green, 4 blue; 1 blue, 11 red, 4 green\n" +
        "Game 87: 5 green, 5 red, 15 blue; 4 blue, 12 red, 10 green; 3 green, 11 blue, 9 red; 3 red, 4 green, 16 blue; 3 red, 10 blue, 10 green; 15 blue, 9 green, 12 red\n" +
        "Game 88: 2 green, 10 blue; 4 blue, 8 green; 8 green, 1 blue; 13 blue, 1 red, 2 green; 2 green, 16 blue\n" +
        "Game 89: 5 blue, 7 red; 10 red, 11 blue, 6 green; 6 green, 3 red, 7 blue; 5 green, 3 red, 20 blue; 8 red, 6 green, 10 blue; 7 blue, 5 green, 10 red\n" +
        "Game 90: 4 red, 1 green, 4 blue; 9 red, 9 blue, 9 green; 4 green, 11 red; 9 red, 5 green, 3 blue; 9 red, 2 green, 2 blue\n" +
        "Game 91: 13 green, 13 blue; 3 red, 11 green, 5 blue; 10 blue, 3 green, 1 red; 3 blue, 10 green, 2 red; 5 blue, 2 green\n" +
        "Game 92: 8 blue, 1 green, 4 red; 3 blue, 6 red; 3 red, 1 green, 14 blue; 6 blue, 8 red; 15 blue, 9 red; 4 blue, 2 red\n" +
        "Game 93: 3 blue, 17 red, 2 green; 9 blue, 6 red; 6 blue, 2 green, 16 red; 1 green, 5 blue, 15 red; 3 blue, 2 green, 14 red\n" +
        "Game 94: 7 blue, 19 green, 1 red; 4 blue; 8 blue, 3 red, 4 green\n" +
        "Game 95: 2 green, 6 red, 13 blue; 5 red, 12 green, 12 blue; 18 blue, 8 red, 4 green; 7 red, 6 green, 17 blue; 4 green, 9 red, 6 blue; 10 red, 1 green, 4 blue\n" +
        "Game 96: 8 blue, 9 red; 9 red, 10 blue; 5 blue, 1 green, 2 red; 2 blue, 2 red\n" +
        "Game 97: 4 red, 1 blue, 2 green; 2 green, 11 red, 1 blue; 8 red, 1 green; 7 red, 3 green, 1 blue; 5 red, 1 green, 1 blue\n" +
        "Game 98: 6 green, 4 blue, 12 red; 3 blue, 13 red, 1 green; 2 blue, 12 green, 2 red; 13 green, 2 red, 1 blue; 10 red, 7 green, 1 blue\n" +
        "Game 99: 6 blue, 3 green, 5 red; 3 green, 6 red, 8 blue; 3 green, 11 blue, 14 red; 14 red, 5 green, 1 blue\n" +
        "Game 100: 16 red, 3 blue; 2 red, 5 green; 9 red; 1 blue, 3 green, 10 red; 1 red, 5 blue, 3 green; 12 blue, 9 red"

solvePuzzle(testCase)