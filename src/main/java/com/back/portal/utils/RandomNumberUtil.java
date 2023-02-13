package com.back.portal.utils;

import java.util.Random;

public class RandomNumberUtil {
    public static int getRandomFromLimit(int limit) {
        return new Random().nextInt(limit);
    }
}
