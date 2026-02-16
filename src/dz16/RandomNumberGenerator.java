package dz16;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random RANDOM = new Random();

    public static int generateRandomNumber(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}