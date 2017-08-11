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
 * 创建日期：8/8 0008
 * 描    述：画自定义图形 - Path 的第一类方法：直接描述路径的
 * Path 可以描述直线、二次曲线、三次曲线、圆、椭圆、弧形、矩形、圆角矩形。
 * 把这些图形结合起来，就可以描述出很多复杂的图形
 * 修订历史：
 * ================================================
 */
public class PathView extends View {

    private Paint paint = new Paint();
    private Path path = new Path();
    private Path path2 = new Path();

    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);//画笔的颜色
        paint.setAntiAlias(true);//是否开启抗锯齿
        paint.setStrokeWidth(5);// 画笔的宽度
        paint.setStyle(Paint.Style.STROKE);

//        path.addArc(200, 200, 400, 400, -225, 225);
//        path.arcTo(400, 200, 600, 400, -180, 255, false);
//        path.lineTo(400, 550);
        /**
         * Path 有两类方法，一类是直接描述路径的，另一类是辅助的设置或计算。
         */

        // 添加一个圆
        /**
         * x, y, radius 这三个参数是圆的基本信息，最后一个参数 dir 是画圆的路径的方向。
         * 路径方向有两种：顺时针 (CW clockwise) 和逆时针 (CCW counter-clockwise)。
         * 对于普通情况，这个参数填 CW 还是填 CCW 没有影响。
         */
//        path.addCircle(300, 300, 200, Path.Direction.CW);

        // 添加一个椭圆
//        path.addOval(50, 30, 150, 350, Path.Direction.CW);

        // 添加一个矩形
//        path.addRect(50, 50, 300, 300, Path.Direction.CW);

        // 添加一个圆角矩形
//        path.addRoundRect(50, 50, 300, 400, 10, 10, Path.Direction.CW);

        // 添加另一个path
//        path2.addRect(20, 20, 200, 300, Path.Direction.CW);
//        path.addPath(path2);

        // 画直线
//        path.lineTo(200, 200); // lineTo (x,y) 参数x,y 表示绝对坐标 : 由当前位置(0,0) - (100,100)

//        path.rLineTo(0, 100); // rLinto(x,y) 参数x,y表示相对坐标 ： 由上一个当前位置(100,100) 向正下方画一条100 像素的直线

//        path.rLineTo(100, 0);// rLinto(x,y) 参数x,y表示相对坐标 ： 由上一个当前位置(100,200) 向正下方画一条100 像素的直线

        // 画二次贝塞尔曲线
//        path.quadTo(0, 100, 500, 200); //x1, y1 和 x2, y2 则分别是控制点和终点的坐标
//        path.rQuadTo(300,200,100,600); //相对上一个位置坐标 开始画曲线

        //画三次贝塞尔曲线
//        path.cubicTo(0, 100, 400, 200, 500, 100);
//        path.rCubicTo(0, 100, 400, 200, 500, 100);//相对上一个位置坐标 开始画曲线

        // 移动到指定的位置
//        path.lineTo(100, 100);
//        path.moveTo(200, 100);// 移动到 200,100 位置 设置图形的起点
//        path.lineTo(200, 400);// 从 200,100 的位置 开始画线

        // 画弧形
//        path.lineTo(100, 100);
        /**
         * 这个方法和 Canvas.drawArc() 比起来，少了一个参数 useCenter，而多了一个参数 forceMoveTo 。
         *少了 useCenter ，是因为 arcTo() 只用来画弧形而不画扇形，
         * 所以不再需要 useCenter 参数；
         * 而多出来的这个 forceMoveTo 参数的意思是，绘制是要「抬一下笔移动过去」，还是「直接拖着笔过去」，区别在于是否留下移动的痕迹。
         */
//        path.arcTo(100, 100, 300, 300, -90, 90, true);// 强制移动到弧形起点(无痕迹)
//        path.arcTo(100, 100, 300, 300, -90, 90, false);// 直接连线连到弧形起点（有痕迹）

//        path.addArc(100, 100, 300, 300, -90, 90);//addArc() 只是一个直接使用了 forceMoveTo = true 的简化版 arcTo()

        //封闭子图形
        /**
         * 不是所有的子图形都需要使用 close() 来封闭。
         * 当需要填充图形时（即 Paint.Style 为 FILL 或  FILL_AND_STROKE），Path 会自动封闭子图形。
         */
//        paint.setStyle(Paint.Style.FILL);
//        path.moveTo(100, 100);
//        path.lineTo(200, 100);
//        path.lineTo(150, 150);
//        path.close(); //封闭子图形 == path.lineTo(100,100)

        // 练习画心形
        paint.setStyle(Paint.Style.FILL);
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 550);
        path.close();
        canvas.drawPath(path, paint);
    }
}
