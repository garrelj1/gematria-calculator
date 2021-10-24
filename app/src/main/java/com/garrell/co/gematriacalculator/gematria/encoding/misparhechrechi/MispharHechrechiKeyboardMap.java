package com.garrell.co.gematriacalculator.gematria.encoding.misparhechrechi;

import com.garrell.co.gematriacalculator.gematria.UnicodeHebrewAlphabet;
import com.garrell.co.gematriacalculator.gematria.keyboard.KeyboardCharacterMapping;
import com.garrell.co.gematriacalculator.gematria.keyboard.KeyboardCoordinate;

import java.util.HashMap;
import java.util.Map;

public class MispharHechrechiKeyboardMap implements KeyboardCharacterMapping {

    Map<KeyboardCoordinate, String> keyboardMapping = new HashMap<>();

    public MispharHechrechiKeyboardMap() {
        keyboardMapping.put(new KeyboardCoordinate(0, 0), UnicodeHebrewAlphabet.alef);
        keyboardMapping.put(new KeyboardCoordinate(0, 1), UnicodeHebrewAlphabet.bet);
        keyboardMapping.put(new KeyboardCoordinate(0, 2), UnicodeHebrewAlphabet.gimmel);
        keyboardMapping.put(new KeyboardCoordinate(0, 3), UnicodeHebrewAlphabet.dalet);
        keyboardMapping.put(new KeyboardCoordinate(0, 4), UnicodeHebrewAlphabet.heh);
        keyboardMapping.put(new KeyboardCoordinate(1, 0), UnicodeHebrewAlphabet.vav);
        keyboardMapping.put(new KeyboardCoordinate(1, 1), UnicodeHebrewAlphabet.zayin);
        keyboardMapping.put(new KeyboardCoordinate(1, 2), UnicodeHebrewAlphabet.ches);
        keyboardMapping.put(new KeyboardCoordinate(1, 3), UnicodeHebrewAlphabet.tes);
        keyboardMapping.put(new KeyboardCoordinate(1, 4), UnicodeHebrewAlphabet.yud);
        keyboardMapping.put(new KeyboardCoordinate(2, 0), UnicodeHebrewAlphabet.kaf);
        keyboardMapping.put(new KeyboardCoordinate(2, 1), UnicodeHebrewAlphabet.lamed);
        keyboardMapping.put(new KeyboardCoordinate(2, 2), UnicodeHebrewAlphabet.mem);
        keyboardMapping.put(new KeyboardCoordinate(2, 3), UnicodeHebrewAlphabet.nun);
        keyboardMapping.put(new KeyboardCoordinate(2, 4), UnicodeHebrewAlphabet.samekh);
        keyboardMapping.put(new KeyboardCoordinate(3, 0), UnicodeHebrewAlphabet.ayin);
        keyboardMapping.put(new KeyboardCoordinate(3, 1), UnicodeHebrewAlphabet.pe);
        keyboardMapping.put(new KeyboardCoordinate(3, 2), UnicodeHebrewAlphabet.tsadi);
        keyboardMapping.put(new KeyboardCoordinate(3, 3), UnicodeHebrewAlphabet.kuf);
        keyboardMapping.put(new KeyboardCoordinate(3, 4), UnicodeHebrewAlphabet.reish);
    }

    @Override
    public Map<KeyboardCoordinate, String> getMap() {
        return keyboardMapping;
    }

    /*
            <string name="alef">\u05d0</string>
    <string name="bet">\u05d1</string>
    <string name="gimmel">\u05d2</string>
    <string name="dalet">\u05d3</string>
    <string name="heh">\u05d4</string>
    <string name="vav">\u05d5</string>
    <string name="zayin">\u05d6</string>
    <string name="ches">\u05d7</string>
    <string name="tes">\u05d8</string>
    <string name="yud">\u05d9</string>
    <string name="final_kaf">\u05da</string>
    <string name="kaf">\u05db</string>
    <string name="lamed">\u05dc</string>
    <string name="final_mem">\u05dd</string>
    <string name="mem">\u05de</string>
    <string name="final_nun">\u05df</string>
    <string name="nun">\u05e0</string>
    <string name="samekh">\u05e1</string>
    <string name="ayin">\u05e2</string>
    <string name="final_pe">\u05e3</string>
    <string name="pe">\u05e4</string>
    <string name="final_tsadi">\u05e5</string>
    <string name="tsadi">\u05e6</string>
    <string name="kuf">\u05e7</string>
    <string name="reish">\u05e8</string>
    <string name="shin">\u05e9</string>
    <string name="tav">\u05ea</string>
     */


}
