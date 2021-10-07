package com.garrell.co.gematriacalculator.screens.calculator.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.view.ContextThemeWrapper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.garrell.co.baseapp.R;
import com.garrell.co.baseapp.screens.common.mvcviews.BaseObservableViewMvc;
import com.garrell.co.gematriacalculator.gematria.keyboard.KeyboardCoordinate;
import com.google.android.material.button.MaterialButton;

import java.util.Map;

public class CalculatorViewMvcImpl extends BaseObservableViewMvc<CalculatorViewMvc.Listener>
        implements CalculatorViewMvc {

    private final TextView tv;

    public CalculatorViewMvcImpl(LayoutInflater layoutInflater, ViewGroup container) {
        View view = layoutInflater.inflate(R.layout.layout_calculator, container, false);
        setRootView(view);

        tv = findViewById(R.id.hebrew_input);
    }

    private void addCharToInputAndNotify(char in) {
        String newInput = getInputAfterAddingChar(in);
        updateHebrewInputTextView(newInput);
        notifyListenersInputUpdated(newInput);
    }

    private String getInputAfterAddingChar(char in) {
        String oldInput = getOldInput();
        return oldInput + in;
    }

    private void removeCharFromInputAndNotify() {
        String newInput = getInputAfterRemovingChar();
        updateHebrewInputTextView(newInput);
        notifyListenersInputUpdated(newInput);
    }

    private String getInputAfterRemovingChar() {
        String oldInput = getOldInput();

        if (oldInput.length() == 0)
            return "";

        return "";
    }

    private String getOldInput() {
        TextView tv = findViewById(R.id.hebrew_input);
        return tv.getText().toString();
    }

    private void updateHebrewInputTextView(String newInput) {
        TextView tv = findViewById(R.id.hebrew_input);
        tv.setText(newInput);
    }

    private void notifyCharacterButtonClicked(Character newChar) {
        String oldInput = tv.getText().toString();
        for (Listener l : getListeners())
            l.onCharacterEntered(oldInput, newChar);
    }

    private void notifyListenersInputUpdated(String newInput) {
    }

    @Override
    public void layoutKeyboard(Map<KeyboardCoordinate, Character> keyboardMapping) {
        ConstraintLayout parent = findViewById(R.id.keyboard_layout);
        ConstraintSet set = new ConstraintSet();

        for (Map.Entry<KeyboardCoordinate, Character> entry : keyboardMapping.entrySet()) {
            int row = entry.getKey().row;
            int column = entry.getKey().column;

            ContextThemeWrapper themeWrapper = new ContextThemeWrapper(getContext(), R.style.Hebrew_Keyboard_Button);
            MaterialButton childView = new MaterialButton(themeWrapper);
            int id = getViewId(row, column);
            childView.setId(id);

            childView.setOnClickListener(v -> {
                notifyCharacterButtonClicked(entry.getValue());
            });

            // set view id, else getId() returns -1
            childView.setText(entry.getValue().toString());

            parent.addView(childView, 0);

            set.clone(parent);
            set.setDimensionRatio(childView.getId(), "H,1:1");

            if (row == 0)
                set.connect(
                        childView.getId(), ConstraintSet.RIGHT,
                        parent.getId(), ConstraintSet.RIGHT,
                        50
                );

            if (column == 0)
                set.connect(
                        childView.getId(), ConstraintSet.TOP,
                        R.id.numerical_value, ConstraintSet.BOTTOM,
                        50);

            if (column > 0 && column < 5) {
                set.connect(
                        childView.getId(), ConstraintSet.RIGHT,
                        getIdOfViewToRight(row, column), ConstraintSet.LEFT,
                        50);
                set.connect(
                        childView.getId(), ConstraintSet.TOP,
                        getIdOfViewToRight(row, column), ConstraintSet.TOP
                );
            }


            // Do this for all views
            set.applyTo(parent);

            // connect start and end point of views, in this case top of child to top of parent.
            // ... similarly add other constraints
        }

        findViewById(R.id.backspace).setOnClickListener(v -> {
            removeCharFromInputAndNotify();
        });

    }

    @Override
    public void setHebrewInput(String input) {
        tv.setText(input);
    }

    private int getViewId(int row, int column) {
        return ("row" + row + "column" + column).hashCode();
    }

    private int getIdOfViewToRight(int row, int column) {
        if (column == 0)
            throw new IndexOutOfBoundsException();

        int columnToTheRight = column - 1;
        return getViewId(row, columnToTheRight);
    }

}
