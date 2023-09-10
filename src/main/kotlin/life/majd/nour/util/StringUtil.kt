package life.majd.nour.util

import kotlin.random.Random

class StringUtil {

    companion object {
        private const val STRING_LENGTH = 8
        private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        fun generateRandomCode() = (1..STRING_LENGTH)
            .map { Random.nextInt(0, charPool.size).let { charPool[it] } }
            .joinToString("")
    }
}
