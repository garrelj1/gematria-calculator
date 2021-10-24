package com.garrell.co.gematriacalculator.calculator.misparhechrechi;

import com.garrell.co.gematriacalculator.calculator.Calculator;
import com.garrell.co.gematriacalculator.gematria.UnicodeHebrewAlphabet;

import java.util.HashMap;
import java.util.Map;

public class MisparHechrechiCalculator implements Calculator {

    private final Map<String, Integer> letterValues = new HashMap<String, Integer>() {{
        put(UnicodeHebrewAlphabet.alef, 1);
        put(UnicodeHebrewAlphabet.bet, 2);
        put(UnicodeHebrewAlphabet.gimmel, 3);
        put(UnicodeHebrewAlphabet.dalet, 4);
        put(UnicodeHebrewAlphabet.heh, 5);
        put(UnicodeHebrewAlphabet.vav, 6);
        put(UnicodeHebrewAlphabet.zayin, 7);
        put(UnicodeHebrewAlphabet.ches, 8);
        put(UnicodeHebrewAlphabet.tes, 9);
        put(UnicodeHebrewAlphabet.yud, 10);
        put(UnicodeHebrewAlphabet.kaf, 20);
        put(UnicodeHebrewAlphabet.lamed, 30);
        put(UnicodeHebrewAlphabet.mem, 40);
        put(UnicodeHebrewAlphabet.nun, 50);
        put(UnicodeHebrewAlphabet.samekh, 60);
        put(UnicodeHebrewAlphabet.ayin, 70);
        put(UnicodeHebrewAlphabet.pe, 80);
        put(UnicodeHebrewAlphabet.tsadi, 90);
        put(UnicodeHebrewAlphabet.kuf, 100);
        put(UnicodeHebrewAlphabet.reish, 200);
        put(UnicodeHebrewAlphabet.shin, 300);
        put(UnicodeHebrewAlphabet.tav, 400);
    }};

    @Override
    public boolean isInputValid(String input) {
        if (input.isEmpty())
            return true;

        boolean valid = true;
        for (Character c : input.toCharArray()) {
            Integer value = letterValues.get(Character.toString(c));

            if (value == null)
                valid = false;
        }

        return valid;
    }

    @Override
    public int calculate(String input) {
        int sum = 0;
        for (Character c : input.toCharArray())
            sum += valueOfChar(c);

        return sum;
    }

    private int valueOfChar(Character c) {
        return letterValues.get(c.toString());
    }

}
