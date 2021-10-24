package com.garrell.co.gematriacalculator.screens.calculator.view;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

    private static final int MAX_WIDTH_INDEX = 4;

    private final TextView input;
    private final TextView inputValue;
    private final ConstraintLayout viewGroup;

    public CalculatorViewMvcImpl(LayoutInflater layoutInflater, ViewGroup container) {
        View view = layoutInflater.inflate(R.layout.layout_calculator, container, false);
        setRootView(view);

        input = findViewById(R.id.hebrew_input);
        inputValue = findViewById(R.id.numerical_value);
        viewGroup = findViewById(R.id.keyboard_layout);

        findViewById(R.id.backspace).setOnClickListener(this::notifyBackspaceClicked);
        findViewById(R.id.clear).setOnClickListener(this::notifyClearClicked);
    }

    @Override
    public void setHebrewInput(String txt) {
        input.setText(txt);
    }

    @Override
    public void setInputValue(int value) {
        inputValue.setText(Integer.toString(value));
    }

    private void notifyBackspaceClicked(View view) {
        for (Listener l : getListeners())
            l.onBackspaceClicked();
    }

    private void notifyCharacterButtonClicked(String newChar) {
        for (Listener l : getListeners())
            l.onCharacterEntered(newChar);
    }

    private void notifyClearClicked(View view) {
        for (Listener l : getListeners())
            l.onClearClicked();
    }

    @Override
    public void layoutKeyboard(Map<KeyboardCoordinate, String> keyboardMapping) {

        for (Map.Entry<KeyboardCoordinate, String> entry : keyboardMapping.entrySet()) {
            addViewToParent(entry);
        }

        ConstraintLayout parent = findViewById(R.id.keyboard_layout);
        ConstraintSet set = new ConstraintSet();

        for (Map.Entry<KeyboardCoordinate, String> entry : keyboardMapping.entrySet()) {
            int row = entry.getKey().row;
            int column = entry.getKey().column;

            set.clone(parent);
            set.setDimensionRatio(getViewId(row, column), "H,1:1");

            if (isTopRow(row))
                set.connect(getViewId(row, column), ConstraintSet.TOP,
                            R.id.numerical_value, ConstraintSet.BOTTOM);
            else
                set.connect(getViewId(row, column), ConstraintSet.TOP,
                            getIdOfViewAbove(row, column), ConstraintSet.BOTTOM);

            if (isRightBoundary(column)) {
                set.connect(getViewId(row, column), ConstraintSet.RIGHT,
                            parent.getId(), ConstraintSet.RIGHT);
                set.connect(getViewId(row, column), ConstraintSet.LEFT,
                            getIdOfViewToLeft(row, column), ConstraintSet.RIGHT);
            }

            if (isMiddleColumn(column)) {
                set.connect(getViewId(row, column), ConstraintSet.RIGHT,
                            getIdOfViewToRight(row, column), ConstraintSet.LEFT);
                set.connect(getViewId(row, column), ConstraintSet.LEFT,
                            getIdOfViewToLeft(row, column), ConstraintSet.RIGHT);
            }

            if (isLeftBoundary(column)) {
                set.connect(getViewId(row, column), ConstraintSet.RIGHT,
                            getIdOfViewToRight(row, column), ConstraintSet.LEFT);
                set.connect(getViewId(row, column), ConstraintSet.LEFT,
                            parent.getId(), ConstraintSet.LEFT);
            }

            set.applyTo(parent);
        }

    }

    private void addViewToParent(Map.Entry<KeyboardCoordinate, String> entry) {
        int row = entry.getKey().row;
        int column = entry.getKey().column;

        ContextThemeWrapper themeWrapper = new ContextThemeWrapper(getContext(), R.style.Hebrew_Keyboard_Button);
        MaterialButton childView = new MaterialButton(themeWrapper);
        childView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        childView.setTextColor(Color.BLACK);
        childView.setBackgroundColor(Color.WHITE);

        int id = getViewId(row, column);
        childView.setId(id);

        childView.setOnClickListener(v -> notifyCharacterButtonClicked(entry.getValue()));

        childView.setText(entry.getValue().toString());

        viewGroup.addView(childView, 0);
    }

    private boolean isLeftBoundary(int column) {
        return column == MAX_WIDTH_INDEX;
    }

    private boolean isMiddleColumn(int column) {
        return !isRightBoundary(column) && !isLeftBoundary(column);
    }

    private boolean isRightBoundary(int column) {
        return column == 0;
    }

    private boolean isTopRow(int row) {
        return row == 0;
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

    private int getIdOfViewAbove(int row, int column) {
        if (row == 0)
            throw new IndexOutOfBoundsException();

        int rowAbove = row - 1;
        return getViewId(rowAbove, 0);
    }

    private int getIdOfViewToLeft(int row, int column) {
        if (column == MAX_WIDTH_INDEX)
            throw new IndexOutOfBoundsException();

        int columnLeft = column + 1;
        return getViewId(row, columnLeft);
    }

}
