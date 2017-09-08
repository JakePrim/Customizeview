package com.linksu.customize_view.viewText;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Locale;

/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：9/8 0008
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class TextTwoView extends View {

    private Paint paint = new Paint();

    private String text[] = new String[]{"测量文字自动计算下移的值", "Hello", "VideoFeed", "测试文字的宽度"};

    public TextTwoView(Context context) {
        super(context);
    }

    public TextTwoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextTwoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        paint.setTextSize(60);

        //getFontSpacing 获取推荐的行距
        canvas.drawText(text[0], 100, 150, paint);
        canvas.drawText(text[1], 100, 150 + paint.getFontSpacing(), paint);
        canvas.drawText(text[2], 100, 150 + paint.getFontSpacing() * 2, paint);
        canvas.drawText(text[3], 100, 150 + paint.getFontSpacing() * 3, paint);

        //measureText 返回文字的宽度
        float v = paint.measureText(text[3]);
        canvas.drawLine(100, 150 + paint.getFontSpacing() * 3, 100 + v, 150 + paint.getFontSpacing() * 3, paint);

        //getTextBounds 获取文字的显示范围
        String text = "获取文字的显示范围";
        canvas.drawText(text, 100, 150 + paint.getFontSpacing() * 4, paint);
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        rect.left += 100;
        rect.top += 150 + paint.getFontSpacing() * 4;
        rect.right += 100;
        rect.bottom += 150 + paint.getFontSpacing() * 4;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(rect, paint);
        //注意：
        // getTextBounds: 它测量的是文字的显示范围（关键词：显示）。
        // 形象点来说，你这段文字外放置一个可变的矩形，然后把矩形尽可能地缩小，一直小到这个矩形恰好紧紧包裹住文字，那么这个矩形的范围，就是这段文字的 bounds。
        // measureText(): 它测量的是文字绘制时所占用的宽度（关键词：占用）

        //getTextWidths(String text, float[] widths) 获取字符串中每个字符的宽度，并把结果填入参数 widths

        //breakText 这个方法也是用来测量文字宽度的,如果文字的宽度超出了上限，那么在临近超限的位置截断文字
        int measuredCount;
        float[] measuredWidth = {0};
        String text1 = "获取文字的显示范围并截取";
        measuredCount = paint.breakText(text1, 0, text1.length(), true, 400, measuredWidth);
        canvas.drawText(text1, 0, measuredCount, 150, 150 + paint.getFontSpacing() * 5, paint);

        //练习项目

        String text2 = "三个月内你胖了";
        float v1 = paint.measureText(text2);
        canvas.drawText(text2, 150, 150 + paint.getFontSpacing() * 7, paint);

        String text3 = "4.5";
        paint.setColor(Color.RED);
        paint.setTextSize(60);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float ascent = fontMetrics.top;
        float descent = fontMetrics.bottom;
        float v3 = descent - ascent;//获取文字的高度
        Log.e("linksu",
                "onDraw(TextTwoView.java:106) Y " + (150 + paint.getFontSpacing() * 7));
        Log.e("linksu",
                "onDraw(TextTwoView.java:106) L Y " + ((150 + paint.getFontSpacing() * 7) - v3));
        float v2 = paint.measureText(text3);
        canvas.drawText(text3, 150 + v1 + 10, (150 + paint.getFontSpacing() * 7), paint);

        String text4 = "公斤";
        paint.setColor(Color.BLACK);
        paint.setTextSize(60);
        canvas.drawText(text4, 150 + v1 + v2, 150 + paint.getFontSpacing() * 7, paint);

    }
}
