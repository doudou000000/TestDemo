package com.test.demo.test.apiDemo.animation.property;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class FixedGridLayout extends ViewGroup {

    private int mCellWidth,mCellHeight;

    public FixedGridLayout(Context context) {
        super(context);
    }

    public void setmCellWidth(int mCellWidth) {
        this.mCellWidth = mCellWidth;
        requestLayout();
    }

    public void setmCellHeight(int mCellHeight) {
        this.mCellHeight = mCellHeight;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int cellWidthSpec = MeasureSpec.makeMeasureSpec(mCellWidth,
                MeasureSpec.AT_MOST);
        int cellHeightSpec = MeasureSpec.makeMeasureSpec(mCellHeight,
                MeasureSpec.AT_MOST);

        int count = getChildCount();
        for (int index=0; index<count; index++) {
            final View child = getChildAt(index);
            child.measure(cellWidthSpec, cellHeightSpec);
        }
        // Use the size our parents gave us, but default to a minimum size to avoid
        // clipping transitioning children
        int minCount =  count > 3 ? count : 3;
        setMeasuredDimension(resolveSize(mCellWidth * minCount, widthMeasureSpec),
                resolveSize(mCellHeight * minCount, heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int cellWidth = mCellWidth;
        int cellHeight = mCellHeight;
        int columns = (r - 1) / cellWidth;//8
        if (columns < 0) {
            columns = 1;
        }
        int x = 0;
        int y = 0;
        int i = 0;
        int count = getChildCount();
        for (int index=0; index<count; index++) {
            final View child = getChildAt(index);

            int w = child.getMeasuredWidth();
            int h = child.getMeasuredHeight();

            int left = x + ((cellWidth-w)/2);
            int top = y + ((cellHeight-h)/2);

            child.layout(left, top, left+w, top+h);
            if (i >= (columns-1)) {
                // advance to next row
                i = 0;
                x = 0;
                y += cellHeight;
            } else {
                i++;
                x += cellWidth;
            }
        }

    }
}
