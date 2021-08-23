package com.garrell.co.gematriacalculator.screens.calculator.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.garrell.co.baseapp.R;
import com.garrell.co.baseapp.screens.common.mvcviews.BaseObservableViewMvc;

public class CalculatorViewMvcImpl extends BaseObservableViewMvc<CalculatorViewMvc.Listener>
        implements CalculatorViewMvc {

    public CalculatorViewMvcImpl(LayoutInflater layoutInflater, ViewGroup container) {
        View view = layoutInflater.inflate(R.layout.layout_calculator, container, false);
        setRootView(view);

        findViewById(R.id.hebrew_input);
        findViewById(R.id.alef).setOnClickListener(v -> {
        });
    }

}
