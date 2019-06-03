package com.bwei.sunyongzheng;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

public class ZdyView extends View {
    public ZdyView(Context context,AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.ZdyView);
        int integer = array.getInteger(R.styleable.ZdyView_c, 0);
        String string = array.getString(R.styleable.ZdyView_axWidth);
        array.recycle();
    }

}
