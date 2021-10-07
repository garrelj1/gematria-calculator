package com.garrell.co.gematriacalculator.gematria.encoding.misparhechrechi;

import com.garrell.co.gematriacalculator.gematria.keyboard.KeyboardCharacterMapping;
import com.garrell.co.gematriacalculator.gematria.keyboard.KeyboardCoordinate;

import java.util.HashMap;
import java.util.Map;

public class MispharHechrechiKeyboardMap implements KeyboardCharacterMapping {

    Map<KeyboardCoordinate, Character> keyboardMapping = new HashMap<>();

    public MispharHechrechiKeyboardMap() {
        keyboardMapping.put(new KeyboardCoordinate(0, 0), (char) 0x05d0);
        keyboardMapping.put(new KeyboardCoordinate(0, 1), (char) 0x05d1);
    }

    @Override
    public Map<KeyboardCoordinate, Character> getMap() {
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
