package com.garrell.co.gematriacalculator.calculator;

import com.garrell.co.baseapp.common.observable.BaseObservable;

public class InputValueCalculatorUseCase extends BaseObservable<InputValueCalculatorUseCase.Listener> {

    public interface Listener {
        void onUpdatedValue(String input, int value);
        void onInputInvalid();
    }

    private String input = "";
    private final Calculator calculator;

    public InputValueCalculatorUseCase(Calculator calculator) {
        this.calculator = calculator;
    }

    public void addInput(String c) {
        input += c;

        if (calculator.isInputValid(input))
            calculateValueAndNotify();
        else
            notifyInputInvalid();
    }

    public void removeCharacter() {
        removeCharacterAndNotify();
    }

    public void clearInput() {
        input = "";

        for (Listener l : getListeners())
            l.onUpdatedValue(input, 0);
    }

    private void removeCharacterAndNotify() {
        if (input.isEmpty())
            return;

        input = input.substring(0, input.length() - 1);
        calculateValueAndNotify();
    }

    private void calculateValueAndNotify() {
        int value = calculator.calculate(input);

        for (Listener l : getListeners())
            l.onUpdatedValue(input, value);
    }

    private void notifyInputInvalid() {
        for (Listener l : getListeners())
            l.onInputInvalid();
    }

}
