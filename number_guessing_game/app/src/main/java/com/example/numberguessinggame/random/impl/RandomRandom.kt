package com.example.numberguessinggame.random.impl

import com.example.numberguessinggame.random.RandomNumberGenerator
import java.util.*

class RandomRandom: RandomNumberGenerator {
    private val rand: Random = Random()
    override fun rnd(minInt: Int, maxInt: Int): Int {
        val span = maxInt - minInt + 1
        return minInt + rand.nextInt(span)
    }
}