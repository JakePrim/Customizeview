package com.linksu.customize_view.viewText;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
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
public class TextOneView extends View {

    Paint paint = new Paint();

    public TextOneView(Context context) {
        super(context);
    }

    public TextOneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextOneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        paint.setTextSize(60);

        /**
         * x 和 y 是文字的坐标。
         * 但需要注意：这个坐标并不是文字的左上角，而是一个与左下角比较接近的位置
         */
        canvas.drawText("Hello", 100, 100, paint);

        //drawTextOnPath()
        /**
         * hOffset 和 vOffset。它们是文字相对于 Path 的水平偏移量和竖直偏移量，
         * 利用它们可以调整文字的位置。
         * 例如你设置 hOffset 为 5， vOffset 为 10，
         * 文字就会右移 5 像素和下移 10 像素。
         */
        Path path = new Path();
        path.moveTo(10, 100);
        path.lineTo(300, 10);
        canvas.drawPath(path, paint);
        canvas.drawTextOnPath("Hello", path, 5, 10, paint);

        //StaticLayout 支持自动换行，也会在 \n 处主动换行 而 drawText 不支持自动换行
        /**
         * width 是文字区域的宽度，文字到达这个宽度后就会自动换行；
         * align 是文字的对齐方向；
         * spacingmult 是行间距的倍数，通常情况下填 1 就好；
         * spacingadd 是行间距的额外增加值，通常情况下填 0 就好；
         * includeadd 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界。
         */
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(40);
        String text1 = "StaticLayout draw text of the printing and typesetting industy";
        StaticLayout staticLayout = new StaticLayout(text1, textPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);

        String text2 = "aaa\nbbb\nccc\nddd\n";
        StaticLayout staticLayout1 = new StaticLayout(text2, textPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);

        canvas.save();
        canvas.translate(50, 100);
        staticLayout.draw(canvas);
        canvas.translate(0, 200);
        staticLayout1.draw(canvas);

        canvas.restore();

        //setTypeface 设置字体
        paint.setTypeface(Typeface.DEFAULT);
        canvas.drawText("Hello 设置字体", 150, 300, paint);

        paint.setTypeface(Typeface.SERIF);
        canvas.drawText("Hello 设置字体", 150, 380, paint);

        paint.setTypeface(Typeface.MONOSPACE);
        //setFakeBoldText 是否使用伪粗体
        //它并不是通过选用更高 weight 的字体让文字变粗，而是通过程序在运行时把文字给「描粗」了。
//        paint.setFakeBoldText(true);
        canvas.drawText("Hello 设置字体", 150, 450, paint);
        //设置自己导入的字体
//        paint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "Satisfy-Regular.ttf"));

        //setStrikeThruText 是否加删除线
        Paint paint1 = new Paint();
        paint1.setTextSize(60);
        paint1.setStrikeThruText(true);
        canvas.drawText("删除线", 150, 500, paint1);

        //setUnderlineText 是否加下划线
        Paint paint2 = new Paint();
        paint2.setTextSize(60);
        paint2.setUnderlineText(true);
        canvas.drawText("下划线", 150, 580, paint2);

        //setTextSkewX 文字倾斜
        Paint paint3 = new Paint();
        paint3.setTextSize(60);
        paint3.setTextSkewX(-0.8f);
        canvas.drawText("文字倾斜", 150, 650, paint3);

        //setTextScaleX 文字横向缩放
        Paint paint4 = new Paint();
        paint4.setTextSize(60);
        paint4.setTextScaleX(0.8f);
        canvas.drawText("文字变瘦", 150, 720, paint4);
        paint4.setTextScaleX(1.2f);
        canvas.drawText("文字变胖", 150, 780, paint4);
        paint4.setTextScaleX(1.0f);
        canvas.drawText("文字正常", 150, 850, paint4);

        //setLetterSpacing 字符间距
        Paint paint5 = new Paint();
        paint5.setTextSize(60);
        paint5.setLetterSpacing(0.2f);
        canvas.drawText("字符间距 0.2f Hello", 600, 300, paint5);

        //setFontFeatureSettings 用 CSS 的 font-feature-settings 的方式来设置文字。
        Paint paint6 = new Paint();
        paint6.setTextSize(60);
        paint6.setFontFeatureSettings("smcp");
        canvas.drawText("Hello", 600, 400, paint6);

        //setTextLocale 绘制的文字使用什么样的语言
        Paint paint7 = new Paint();
        paint7.setTextSize(60);
        paint7.setTextLocale(Locale.ENGLISH); // 日语
        canvas.drawText("海贼王", 650, 500, paint7);


    }
}
