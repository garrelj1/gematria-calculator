package com.garrell.co.gematriacalculator.screens.calculator.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.garrell.co.baseapp.screens.common.ViewMvcFactory;
import com.garrell.co.baseapp.screens.common.controller.BaseFragment;
import com.garrell.co.gematriacalculator.calculator.InputValueCalculatorUseCase;
import com.garrell.co.gematriacalculator.gematria.keyboard.KeyboardCharacterMapping;
import com.garrell.co.gematriacalculator.screens.calculator.view.CalculatorViewMvc;

import timber.log.Timber;

public class CalculatorFragment extends BaseFragment
        implements CalculatorViewMvc.Listener,
        InputValueCalculatorUseCase.Listener
{

    private KeyboardCharacterMapping keyboard;

    private ViewMvcFactory viewMvcFactory;
    private CalculatorViewMvc viewMvc;

    private InputValueCalculatorUseCase valueCalculatorUseCase;

    public static CalculatorFragment newInstance() {
        return new CalculatorFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewMvcFactory = getControllerCompositionRoot().getViewMvcFactory();
        keyboard = getControllerCompositionRoot().getKeyboardCharacterMapping();
        valueCalculatorUseCase = getControllerCompositionRoot().getInputValueCalculatorUseCase();
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
    public void onResume() {
        viewMvc.registerListener(this);
        valueCalculatorUseCase.registerListener(this);

        super.onResume();
    }

    @Override
    public void onPause() {
        viewMvc.unregisterListener(this);
        valueCalculatorUseCase.unregisterListener(this);

        super.onPause();
    }

    @Override
    public void onCharacterEntered(String newChar) {
        Timber.i("Entered %s with", newChar);
        valueCalculatorUseCase.addInput(newChar);
    }

    @Override
    public void onBackspaceClicked() {
        valueCalculatorUseCase.removeCharacter();
    }

    @Override
    public void onClearClicked() {
        valueCalculatorUseCase.clearInput();
    }

    @Override
    public void onUpdatedValue(String input, int value) {
        viewMvc.setHebrewInput(input);
        viewMvc.setInputValue(value);
    }

    @Override
    public void onInputInvalid() {
        viewMvc.setInputValue(0);
    }

}
