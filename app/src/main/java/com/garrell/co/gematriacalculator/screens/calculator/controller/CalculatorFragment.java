package com.garrell.co.gematriacalculator.screens.calculator.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.garrell.co.baseapp.screens.common.ViewMvcFactory;
import com.garrell.co.baseapp.screens.common.controller.BaseFragment;
import com.garrell.co.gematriacalculator.gematria.keyboard.KeyboardCharacterMapping;
import com.garrell.co.gematriacalculator.screens.calculator.view.CalculatorViewMvc;

import timber.log.Timber;

public class CalculatorFragment extends BaseFragment implements CalculatorViewMvc.Listener {

    private CalculatorViewMvc viewMvc;
    private KeyboardCharacterMapping keyboard;
    private ViewMvcFactory viewMvcFactory;

    public static CalculatorFragment newInstance() {
        return new CalculatorFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewMvcFactory = getControllerCompositionRoot().getViewMvcFactory();
        keyboard = getControllerCompositionRoot().getKeyboardCharacterMapping();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewMvc = viewMvcFactory.newCalculatorViewMvc(container);

        viewMvc.layoutKeyboard(keyboard.getMap());

        return viewMvc.getRootView();
    }

    @Override
    public void onCharacterEntered(String entry) {
        Timber.i("Entered %s", entry);
    }

}
