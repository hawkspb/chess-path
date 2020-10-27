package com.example.chesspath.utils;

public class BoardUtils {
    private static final char MIN_HORIZONTAL = 'A';
    private static final char MAX_HORIZONTAL = 'H';
    private static final char MIN_VERTICAL = '1';
    private static final char MAX_VERTICAL = '8';

    public static String move(String source, int horizontalSteps, int verticalSteps) {
        int horizontal = source.charAt(0);
        int vertical = source.charAt(1);

        int nextHorizontal = horizontal + horizontalSteps;
        if (MIN_HORIZONTAL > nextHorizontal || nextHorizontal > MAX_HORIZONTAL) return null;

        int nextVertical = vertical + verticalSteps;
        if (MIN_VERTICAL > nextVertical || nextVertical > MAX_VERTICAL) return null;

        return String.format("%s%s", (char) nextHorizontal, (char) nextVertical);
    }

}
