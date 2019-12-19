package com.laoxu.layoutdemo.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.laoxu.layoutdemo.R;

/**
 * 组合控件，标题栏控件
 */
public class TitleLayout extends LinearLayout {


    public TitleLayout(Context context) {
        super(context);
        init(context,null);
    }

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public TitleLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    /**
     * 初始化的方法
     * @param context
     * @param attrs
     */
    public void init(Context context, AttributeSet attrs){
        View view = View.inflate(getContext(), R.layout.title_layout,null);
        addView(view);

        //自定义属性配置
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TitleLayout);

        //拿属性，颜色和大小
        //颜色
        int color = typedArray.getColor(R.styleable.TitleLayout_titleColor, Color.BLACK);
        //大小
        int size = typedArray.getDimensionPixelSize(R.styleable.TitleLayout_titleSize,50);



        TextView textView = view.findViewById(R.id.tv_name);
        textView.setTextColor(color);
        textView.setTextSize(size);

    }
}
