package geco;

import java.util.Random;

public class PasswordGenerator {

    private static final int SIZE = 8;

    private PasswordGenerator() {

    }

    public static String getRandomPassword() {
        int leftLimit = 33;
        int rightLimit = 122;
        Random random = new Random();

        StringBuilder buffer = new StringBuilder(SIZE);
        for (int i = 0; i < SIZE; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char)randomLimitedInt);
        }

        return buffer.toString();
    }

}
