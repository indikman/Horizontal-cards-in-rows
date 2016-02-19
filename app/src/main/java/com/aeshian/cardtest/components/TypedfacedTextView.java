package com.aeshian.cardtest.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.aeshian.cardtest.R;

/**
 * Created by Indika on 2/16/2016.
 */
public class TypedfacedTextView extends TextView{

    public TypedfacedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if(isInEditMode()){
            return;
        }

        TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.TypedfacedTextView);
        String fontName = styledAttrs.getString(R.styleable.TypedfacedTextView_typeface);
        styledAttrs.recycle();

        if(fontName != null){
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontName);
            setTypeface(typeface);
        }
    }
}
