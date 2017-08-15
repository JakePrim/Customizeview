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
 * 描 述：扇形图 需要注意的点：
 * startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度）;
 * sweepAngle 是弧形划过的角度.
 * 修订历史：
 * ==========================================
 */

public class SectorView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();
    private Path path2 = new Path();
    private Path path3 = new Path();
    private Path path4 = new Path();
    private Path path5 = new Path();
    private Path path6 = new Path();

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
        // 绘制第一个扇形
        canvas.drawArc(200, 100, 800, 500, 180, 100, true, paint);//扇形
        canvas.drawText("android", 100, 100, paint);
        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(200, 90);
        path.lineTo(300, 90);
        path.rLineTo(50, 100);
        canvas.drawPath(path, paint);
        // 绘制第二个扇形
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        canvas.drawArc(210, 110, 810, 510, -80, 80, true, paint);//扇形
        canvas.drawText("kotlin", 850, 100, paint);
        paint.setStyle(Paint.Style.STROKE);
        path2.moveTo(700, 160);
        path2.lineTo(800, 90);
        path2.rLineTo(50, 0);
        canvas.drawPath(path2, paint);
        //绘制第三个扇形
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawArc(210, 110, 810, 510, 0, 10, true, paint);//扇形
        canvas.drawText("c#", 900, 350, paint);
        paint.setStyle(Paint.Style.STROKE);
        path3.moveTo(800, 330);
        path3.lineTo(900, 340);
        canvas.drawPath(path3, paint);
        //绘制第四个扇形
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.CYAN);
        canvas.drawArc(210, 110, 810, 510, 10, 5, true, paint);
        canvas.drawText("web", 900, 380, paint);
        paint.setStyle(Paint.Style.STROKE);
        path4.moveTo(800, 350);
        path4.lineTo(850, 350);
        path4.rLineTo(50, 20);
        canvas.drawPath(path4, paint);
        //绘制第五个扇形
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawArc(210, 110, 810, 510, 15, 60, true, paint);
        canvas.drawText("c++", 800, 500, paint);
        paint.setStyle(Paint.Style.STROKE);
        path5.moveTo(700, 400);
        path5.lineTo(800, 450);
        path5.rLineTo(10, 35);
        canvas.drawPath(path5, paint);
        //绘制第六个扇形
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.DKGRAY);
        canvas.drawArc(210, 110, 810, 510, 75, 105, true, paint);
        canvas.drawText("php", 100, 550, paint);
        paint.setStyle(Paint.Style.STROKE);
        path6.moveTo(310, 460);
        path6.lineTo(240, 540);
        path6.rLineTo(-95, 0);
        canvas.drawPath(path6, paint);

    }
}
