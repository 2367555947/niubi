package com.bwei.sunyongzheng.zdyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.bwei.sunyongzheng.R;

public class Zdyview extends View {
    public Zdyview(Context context,AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.Zdyview);
        String string = array.getString(R.styleable.Zdyview_axpath);
        int integer = array.getInteger(R.styleable.Zdyview_bypath, 0);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
