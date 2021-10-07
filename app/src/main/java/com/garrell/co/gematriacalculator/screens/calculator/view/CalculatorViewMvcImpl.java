package com.garrell.co.gematriacalculator.screens.calculator.view;

import android.util.AttributeSet;
import android.util.Pair;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.garrell.co.baseapp.R;
import com.garrell.co.baseapp.screens.common.mvcviews.BaseObservableViewMvc;
import com.garrell.co.gematriacalculator.gematria.keyboard.KeyboardCoordinate;
import com.google.android.material.button.MaterialButton;

import java.util.Map;
import java.util.Set;

public class CalculatorViewMvcImpl extends BaseObservableViewMvc<CalculatorViewMvc.Listener>
        implements CalculatorViewMvc {

    public CalculatorViewMvcImpl(LayoutInflater layoutInflater, ViewGroup container) {
        View view = layoutInflater.inflate(R.layout.dynamic_keyboard, container, false);
        setRootView(view);

        /*
        findViewById(R.id.backspace).setOnClickListener(v -> {
            removeCharFromInputAndNotify();
        });

        findViewById(R.id.row_0_column_0).setOnClickListener(v -> {
            String alef = getString(R.string.alef);
        });
         */
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

        TextView tv = findViewById(R.id.hebrew_input);
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

    private void notifyListenersInputUpdated(String newInput) {
        for (Listener l : getListeners())
            l.onCharacterEntered(newInput);
    }

    @Override
    public void layoutKeyboard(Map<KeyboardCoordinate, Character> keyboardMapping) {
        ConstraintLayout parentLayout = findViewById(R.id.keyboard);
        ConstraintSet set = new ConstraintSet();

        for (Map.Entry<KeyboardCoordinate, Character> entry : keyboardMapping.entrySet()) {
            int row = entry.getKey().row;
            int column = entry.getKey().column;

            MaterialButton childView = new MaterialButton(getContext());

            // set view id, else getId() returns -1
            childView.setId(row + column);
            childView.setText(entry.getValue().toString());
            parentLayout.addView(childView, row);

            set.clone(parentLayout);
            if (row == 0)
            // connect start and end point of views, in this case top of child to top of parent.
            set.connect(childView.getId(), ConstraintSet.TOP, parentLayout.getId(), ConstraintSet.TOP, 60);
            // ... similarly add other constraints
            set.applyTo(parentLayout);
        }
    }

}
