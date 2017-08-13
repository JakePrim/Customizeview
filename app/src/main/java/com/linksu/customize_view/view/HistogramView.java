package com.linksu.customize_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * ==========================================
 * 作 者：linksu (sufululove@gmail.com)
 * 版 本：1.0
 * 创建日期： 2017/8/13
 * 描 述：直方图
 * 修订历史：
 * ==========================================
 */

public class HistogramView extends View {

    private Paint paint = new Paint();
    private Path path = new Path();

    public HistogramView(Context context) {
        super(context);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);//是否开启抗锯齿
        paint.setTextSize(30);

        //绘制背景
        canvas.drawColor(Color.GRAY);

        //绘制坐标系
        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(100,100);
        path.lineTo(100,500);
        path.rLineTo(900, 0); //相对于上一个位置画一条横线
//        path.moveTo(100, 500);
        canvas.drawPath(path, paint);

        //绘制横轴坐标
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("android", 120, 530, paint);
        canvas.drawText("java", 250, 530, paint);
        canvas.drawText("kotlin", 350, 530, paint);
        canvas.drawText("c#", 450, 530, paint);
        canvas.drawText("php", 550, 530, paint);
        canvas.drawText("c++", 650, 530, paint);
        canvas.drawText("web", 750, 530, paint);

        //绘制纵轴坐标
        paint.setColor(Color.BLUE);
        canvas.drawRect(140, 130, 220, 500,paint);
        canvas.drawRect(240, 160, 320, 500,paint);
        canvas.drawRect(340, 160, 420, 500,paint);
        canvas.drawRect(440, 260, 520, 500,paint);
        canvas.drawRect(540, 360, 620, 500,paint);
        canvas.drawRect(640, 360, 720, 500,paint);
        canvas.drawRect(740, 460, 820, 500,paint);


    }
}
