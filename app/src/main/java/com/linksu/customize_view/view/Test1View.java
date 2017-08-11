package com.linksu.customize_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：7/25 0025
 * 描    述： Canvas 所有的简单图形的绘制
 * 修订历史：
 * ================================================
 */
public class Test1View extends View {

    private Paint paint = new Paint();
    private int mWidth = 500;
    private int mHight = 500;

    public Test1View(Context context) {
        super(context);
    }

    public Test1View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Test1View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 解决 自定义view 设置warp_content 无效的问题
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeWidith = MeasureSpec.getSize(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        if (modeWidth == MeasureSpec.AT_MOST && modeHeight == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, mHight);
        } else if (modeWidth == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, sizeHeight);
        } else if (modeHeight == MeasureSpec.AT_MOST) {
            setMeasuredDimension(sizeWidith, mHight);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK); //画笔的颜色
        paint.setStyle(Paint.Style.FILL);//STROKE 画线模式、FILL填充模式(默认为填充模式)、FILL_AND_STROKE（即画线又填充）
        paint.setStrokeWidth(20);// 画笔的宽度
        paint.setAntiAlias(true); // 设置开启 或 关闭 抗锯齿(图形会出现毛边现象)
        //画圆
//        canvas.drawCircle(100, 100, 100, paint);//float cx, float cy ：控制圆心的坐标。float radius ：控制圆的半径

        //画矩形
//        canvas.drawRect(0, 0, 200, 200, paint);//float left, float top : 控制矩形的位置坐标。float right, float bottom ：控制矩形的宽和高
//        @SuppressLint("DrawAllocation") Rect rect = new Rect(10, 10, 200, 200); //矩形其他的重载方法
//        @SuppressLint("DrawAllocation") RectF rectF = new RectF(0, 0, 200, 200);
//        canvas.drawRect(rect, paint);

        //颜色填充
//        canvas.drawColor(Color.BLACK);
        //这类颜色填充方法一般用于在绘制之前设置底色，或者在绘制之后为界面设置半透明蒙版。
//        canvas.drawRGB(100, 200, 100);
//        canvas.drawARGB(100, 100, 200, 100);

        //画单个点
        /**
         * Paint.setStrokeCap(cap) 可以设置点的形状，
         * 但这个方法并不是专门用来设置点的形状的，而是一个设置线条端点形状的方法。
         * 端点有圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE) 三种，具体会在下一节里面讲。
         */
//        paint.setStrokeCap(Paint.Cap.ROUND); // 圆头
//        paint.setStrokeCap(Paint.Cap.BUTT);  // 平头
//        paint.setStrokeCap(Paint.Cap.SQUARE);// 方头
        //注意:设置 paint.setStyle(Paint.Style.STROKE); 画线模式是无效的
//        canvas.drawPoint(50, 50, paint);

        //画批量的点
//        paint.setStrokeCap(Paint.Cap.BUTT);
//        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        /**
         * float[] pts : 这个数组是点的坐标，每两个成一对
         * int offset ：表示跳过数组的前几个数再开始记坐标
         * int count ：表示一共要绘制几个点
         */
        // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
//        canvas.drawPoints(points, 2/* 跳过两个数，即前两个 0 */, 5/*一共绘制四个点*/, paint);

        // 画椭圆
        /**
         * 注意 若right == bottom 画出来的就是个圆形
         */
//        canvas.drawOval(50, 50, 350, 350, paint);//left, top, right, bottom 是这个椭圆的左、上、右、下四个边界点的坐标
//        RectF rectF = new RectF(50, 50, 350, 200);
//        canvas.drawOval(rectF, paint);

        // 画线

        /**
         * float startX, float startY: 起始坐标
         * float stopX, float stopY : 终止坐标
         * 由于直线不是封闭图形，所以 paint.setStyle(style) 对直线没有影响。
         */
//        canvas.drawLine(200, 200, 800, 500, paint);

        // 批量画线
//        float lines[] = {20, 20, 120, 20, 70, 20, 70, 120, 20, 70, 120, 70, 20, 120, 120, 120};
//        canvas.drawLines(lines, paint);

        //画圆角矩形
        /**
         * left, top, right, bottom 是四条边的坐标
         * rx 和 ry 是圆角的横向半径和纵向半径 也就是圆角的角度
         */
//        canvas.drawRoundRect(100, 100, 500, 300, 20, 20, paint);

        //绘制弧形或扇形
        /**
         * drawArc() 是使用一个椭圆来描述弧形的。
         * left, top, right, bottom 描述的是这个弧形所在的椭圆；
         * startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
         * sweepAngle 是弧形划过的角度；
         * useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。
         */
        canvas.drawArc(200, 100, 800, 500, -110, 100, true, paint);//扇形
        canvas.drawArc(200, 100, 800, 500, 20, 140, false, paint);//弧形
        paint.setStyle(Paint.Style.STROKE); //画线模式
        paint.setStrokeWidth(10);// 画笔的宽度
        canvas.drawArc(200, 100, 800, 500, 180, 60, false, paint);//绘制不封口的弧形
    }
}
