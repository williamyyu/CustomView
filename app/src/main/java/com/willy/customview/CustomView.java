package com.willy.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Willy on 2016/12/27.
 */

/*
reference:
    http://www.cnblogs.com/angeldevil/p/3479431.html
    http://www.jianshu.com/p/61b79e7f88fc/
*/
public class CustomView extends View {

    /* Call by programing code */
    public CustomView(Context context) {
        super(context);
    }

    /* Call by xml layout */
    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.CustomViewStyle);
    }

    /**
     * @param context      context
     * @param attrs        attributes from XML => app:mainText="mainText"
     * @param defStyleAttr attributes from default style (Application theme or activity theme)
     */
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        /** Get attributes value
         *  Priority : AttributeSet (XML) > style in AttributeSet (XML) > defStyleAttr > defStyleRes
         */

        // get attributes from AttributeSet (XML) > style in AttributeSet (XML)
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomizeAttributes);

        // get attributes from AttributeSet (XML) > style in AttributeSet (XML) > defStyleAttr > Theme , defStyleRes not worked!
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomizeAttributes, defStyleAttr, R.style.DefaultStyle);

        // get attributes from AttributeSet (XML) > style in AttributeSet (XML) > defStyleRes > Theme
        // defStyleRes only work when defStyleAttr is 0.
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomizeAttributes, 0, R.style.DefaultStyle);
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomizeAttributes, 0, R.style.DefaultStyleInAttrs);

        // get attributes from theme (not worked?)
//        TypedArray typedArray = context.obtainStyledAttributes(R.styleable.CustomizeAttributes);

        for (int i = 0; i < typedArray.getIndexCount(); i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.CustomizeAttributes_attr_one:
                    Log.d(getClass().getName(), "Attribute one = " + typedArray.getString(attr));
                    break;
                case R.styleable.CustomizeAttributes_attr_two:
                    Log.d(getClass().getName(), "Attribute two = " + typedArray.getString(attr));
                    break;
                case R.styleable.CustomizeAttributes_attr_three:
                    Log.d(getClass().getName(), "Attribute three = " + typedArray.getString(attr));
                    break;
                case R.styleable.CustomizeAttributes_attr_four:
                    Log.d(getClass().getName(), "Attribute four = " + typedArray.getString(attr));
                    break;
                case R.styleable.CustomizeAttributes_attr_five:
                    Log.d(getClass().getName(), "Attribute five = " + typedArray.getString(attr));
                    break;
            }
        }

        // reference: http://blog.csdn.net/Monicabg/article/details/45014327
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
