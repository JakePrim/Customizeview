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
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：8/14 0014
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class RingView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();
    private Path path2 = new Path();
    private Path path3 = new Path();
    private Path path4 = new Path();
    private Path path5 = new Path();
    private Path path6 = new Path();

    public RingView(Context context) {
        super(context);
    }

    public RingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(40);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);//是否开启抗锯齿
        paint.setTextSize(30);
        //绘制背景
        canvas.drawColor(Color.GRAY);
        paint.setStrokeCap(Paint.Cap.ROUND); // 圆头
        // 1
        paint.setColor(Color.WHITE);
        path.addArc(300, 300, 900, 900, -90, 10);
        canvas.drawPath(path, paint);
        // 2
        paint.setColor(Color.RED);
        path3.addArc(300, 300, 900, 900, -80, 30);
        canvas.drawPath(path3, paint);
        // 3
        paint.setColor(Color.BLUE);
        path4.addArc(300, 300, 900, 900, 0, -50);
        canvas.drawPath(path4, paint);
        // 4
        paint.setColor(Color.BLACK);
        path2.addArc(300, 300, 900, 900, 0, 100);
        canvas.drawPath(path2, paint);
        // 5
        paint.setColor(Color.CYAN);
        path5.addArc(300, 300, 900, 900, 100, 80);
        canvas.drawPath(path5, paint);
        // 6
        paint.setColor(Color.DKGRAY);
        path6.addArc(300, 300, 900, 900, 180, 90);
        canvas.drawPath(path6, paint);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(0);
        canvas.drawText("各编程语言分布图", 500, 600, paint);
    }
}
