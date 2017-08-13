package com.linksu.customize_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * ==========================================
 * 作 者：linksu (sufululove@gmail.com)
 * 版 本：1.0
 * 创建日期： 2017/8/13
 * 描 述：扇形图
 * 修订历史：
 * ==========================================
 */

public class SectorView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();
    private Path path2 = new Path();
    private Path path3 = new Path();
    private Path path4 = new Path();

    public SectorView(Context context) {
        super(context);
    }

    public SectorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SectorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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
        paint.setColor(Color.RED);
        canvas.drawArc(200, 100, 800, 500, 180, 100, true, paint);//扇形
        canvas.drawText("android", 100, 100, paint);
        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(200, 90);
        path.lineTo(300, 90);
        path.rLineTo(50, 100);
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        canvas.drawArc(210, 110, 810, 510, -80, 80, true, paint);//扇形
        canvas.drawText("kotlin", 850, 100, paint);
        paint.setStyle(Paint.Style.STROKE);
        path2.moveTo(700, 160);
        path2.lineTo(800, 100);
        path2.rLineTo(50, 0);
        canvas.drawPath(path2, paint);
        //startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
        //sweepAngle 是弧形划过的角度；

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawArc(210, 110, 810, 510, 0, 10, true, paint);//扇形
        canvas.drawText("c", 900, 350, paint);
        paint.setStyle(Paint.Style.STROKE);
        path3.moveTo(800, 330);
        path3.lineTo(890, 340);
        canvas.drawPath(path3, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.CYAN);
        canvas.drawArc(210, 110, 810, 510, 10, 5, true, paint);
        paint.setColor(Color.BLACK);
        canvas.drawArc(210, 110, 810, 510, 15, 60, true, paint);
        paint.setColor(Color.DKGRAY);
        canvas.drawArc(210, 110, 810, 510, 75, 105, true, paint);

    }
}
