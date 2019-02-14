package com.black.structional.flyweight;

public class DigitString {
    private DigitChar[] digitChars;
    public DigitString(String s) {
        digitChars = new DigitChar[s.length()];
        DigitFactory digitFactory = DigitFactory.getInstance();
        for (int i = 0; i < s.length(); i++) {
            digitChars[i] = digitFactory.getDigitChar(s.charAt(i) - '0');
        }

    }

    public void print() {
        for (int i = 0; i < digitChars.length; i++) {
            digitChars[i].print();
        }
    }
}
