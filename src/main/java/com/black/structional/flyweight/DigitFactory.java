package com.black.structional.flyweight;

import java.util.HashMap;

public class DigitFactory {
    private HashMap<Integer, DigitChar> pool = new HashMap<>();
    private static DigitFactory digitFactory = new DigitFactory();
    public static DigitFactory getInstance() {
        return digitFactory;
    }

    public DigitChar getDigitChar(int name) {
        DigitChar digitChar = pool.get(name);
        if (digitChar == null) {
            digitChar = new DigitChar(name);
            pool.put(name, digitChar);
        }
        return digitChar;
    }
}
