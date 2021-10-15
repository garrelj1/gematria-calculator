package com.garrell.co.gematriacalculator.calculator.misparhechrechi;

import com.garrell.co.gematriacalculator.calculator.Calculator;
import com.garrell.co.gematriacalculator.gematria.UnicodeHebrewAlphabet;

import java.util.HashMap;
import java.util.Map;

public class MisparHechrechiCalculator implements Calculator {

    private final Map<Character, Integer> letterValues = new HashMap<Character, Integer>() {{
        put(UnicodeHebrewAlphabet.alef, 1);
    }};

    @Override
    public boolean isInputValid(String input) {
        if (input.isEmpty())
            return true;

        return false;
    }

    @Override
    public int calculate(String input) {
        int sum = 0;
        for (Character c : input.toCharArray())
            sum += valueOfChar(c);

        return sum;
    }

    private int valueOfChar(Character c) {
        return letterValues.get(c);
    }

}
