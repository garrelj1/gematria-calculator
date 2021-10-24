package com.garrell.co.gematriacalculator.screens.calculator.view;

import com.garrell.co.baseapp.screens.common.mvcviews.ObservableViewMvc;
import com.garrell.co.gematriacalculator.gematria.keyboard.KeyboardCoordinate;

import java.util.Map;

public interface CalculatorViewMvc extends ObservableViewMvc<CalculatorViewMvc.Listener> {

    interface Listener {
        void onCharacterEntered(String newChar);
        void onBackspaceClicked();
        void onClearClicked();
    }

    void layoutKeyboard(Map<KeyboardCoordinate, String> keyboardMapping);

    void setHebrewInput(String input);

    void setInputValue(int value);
}
