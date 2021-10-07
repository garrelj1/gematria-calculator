package com.garrell.co.gematriacalculator.screens.calculator;

import android.content.Context;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.garrell.co.baseapp.R;

public class Keyboard {

    private Context context;

    public Keyboard(Context context) {
        this.context = context;
    }

    public void stuff() {
        /*
        View view = new View(context);
        ConstraintLayout parentLayout = (ConstraintLayout) view.findViewById(R.id.mainConstraint);
        ConstraintSet set = new ConstraintSet();

        ImageView childView = new ImageView(this);
        // set view id, else getId() returns -1
        childView.setId(View.generateViewId());
        parentLayout.addView(childView, 0);

        set.clone(parentLayout);
        // connect start and end point of views, in this case top of child to top of parent.
        set.connect(childView.getId(), ConstraintSet.TOP, parentLayout.getId(), ConstraintSet.TOP, 60);
        // ... similarly add other constraints
        set.applyTo(parentLayout);
        */
    }

}
