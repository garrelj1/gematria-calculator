package com.garrell.co.gematriacalculator.screens.calculator.view;

import com.garrell.co.baseapp.screens.common.mvcviews.ObservableViewMvc;

public interface CalculatorViewMvc extends ObservableViewMvc<CalculatorViewMvc.Listener> {

    interface Listener {
        void onCharacterEntered(String entry);
    }

}
