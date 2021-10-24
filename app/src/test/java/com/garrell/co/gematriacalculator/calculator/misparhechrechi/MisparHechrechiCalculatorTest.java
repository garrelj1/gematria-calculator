package com.garrell.co.gematriacalculator.calculator.misparhechrechi;

import static org.junit.Assert.*;

import com.garrell.co.gematriacalculator.gematria.UnicodeHebrewAlphabet;

import org.junit.Before;
import org.junit.Test;

public class MisparHechrechiCalculatorTest {

    MisparHechrechiCalculator SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new MisparHechrechiCalculator();
    }

    @Test
    public void isInputValid_emptyInput_returnsTrue() {
        boolean reason = SUT.isInputValid("");
        assertTrue(reason);
    }

    @Test
    public void isInputValid_singleAlefInput_returnsTrue() {
        String input = UnicodeHebrewAlphabet.alef;
        boolean reason = SUT.isInputValid(input);
        assertTrue(reason);
    }

    @Test
    public void isInputValid_singleBetInput_returnsTrue() {
        String input = UnicodeHebrewAlphabet.bet;
        boolean reason = SUT.isInputValid(input);
        assertTrue(reason);
    }

    @Test
    public void isInputValid_alefBetInput_returnsTrue() {
        String input = UnicodeHebrewAlphabet.alef + UnicodeHebrewAlphabet.bet;
        boolean reason = SUT.isInputValid(input);
        assertTrue(reason);
    }

    @Test
    public void calculate_emptyInput() {
        int output = SUT.calculate("");
        assertEquals(0, output);
    }

    @Test
    public void calculate_singleAlefInput_returnsOne() {
        String input = UnicodeHebrewAlphabet.alef;
        int output = SUT.calculate(input);
        assertEquals(1, output);
    }

    @Test
    public void calculate_singleBetInput_returnsTwo() {
        String input = UnicodeHebrewAlphabet.bet;
        int output = SUT.calculate(input);
        assertEquals(2, output);
    }

    @Test
    public void calculate_alefBetInput_returnsThree() {
        String input = UnicodeHebrewAlphabet.alef + UnicodeHebrewAlphabet.bet;
        int output = SUT.calculate(input);
        assertEquals(3, output);
    }

}