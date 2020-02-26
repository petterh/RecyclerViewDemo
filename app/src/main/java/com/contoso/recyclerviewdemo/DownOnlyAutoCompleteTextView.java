package com.contoso.recyclerviewdemo;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;

/**
 * An {@link AppCompatAutoCompleteTextView} that always drops down, except when the available
 * space is less than {@link #MINIMAL_HEIGHT}.
 */
public class DownOnlyAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    private final static int MINIMAL_HEIGHT = 50;

    public DownOnlyAutoCompleteTextView(Context context) {
        super(context);
    }

    public DownOnlyAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DownOnlyAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void showDropDown() {
        Rect displayFrame = new Rect();
        getWindowVisibleDisplayFrame(displayFrame);

        int[] locationOnScreen = new int[2];
        getLocationOnScreen(locationOnScreen);

        int bottom = locationOnScreen[1] + getHeight();
        int availableHeightBelow = displayFrame.bottom - bottom;
        if (availableHeightBelow >= MINIMAL_HEIGHT) {
            setDropDownHeight(availableHeightBelow);
        }

        super.showDropDown();
    }
}
