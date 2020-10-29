package com.him.github.game;

import java.util.Map;
import java.util.Random;

public class RandomGeneratorUtil {
    private static Random random = new Random();

    /**
     * Provides random number from 1 to bound(included).
     * @param bound Including in random number
     * @param exclude Map whose keys need to be excluded while deciding random number.
     * @return
     */
    public static int getRandom(int bound, Map<Integer, Player> exclude) {
        int i = 0;
        do {
            i = random.nextInt(bound) + 1;
        } while (exclude.containsKey(i));
        return i;
    }

    /**
     * Provides random number from 1 to bound(included).
     * @param bound
     * @return
     */
    public static int getRandom(int bound) {
        return random.nextInt(bound) + 1;
    }
}
