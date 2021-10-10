package com.garrell.co.gematriacalculator.screens.calculator.view;

import com.garrell.co.baseapp.screens.common.mvcviews.ObservableViewMvc;
import com.garrell.co.gematriacalculator.gematria.keyboard.KeyboardCoordinate;

import java.util.Map;

public interface CalculatorViewMvc extends ObservableViewMvc<CalculatorViewMvc.Listener> {

    interface Listener {
        void onCharacterEntered(Character newChar);
        void onBackspaceClicked();
    }

    void layoutKeyboard(Map<KeyboardCoordinate, Character> keyboardMapping);

    void setHebrewInput(String input);

}
