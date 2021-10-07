package com.garrell.co.gematriacalculator.screens.calculator.view;

import android.util.Pair;

import com.garrell.co.baseapp.screens.common.mvcviews.ObservableViewMvc;
import com.garrell.co.gematriacalculator.gematria.keyboard.KeyboardCoordinate;

import java.util.Map;

public interface CalculatorViewMvc extends ObservableViewMvc<CalculatorViewMvc.Listener> {

    interface Listener {
        void onCharacterEntered(String entry);
    }

    void layoutKeyboard(Map<KeyboardCoordinate, Character> keyboardMapping);

}
