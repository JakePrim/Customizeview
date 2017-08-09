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
 * 描    述：画自定义图形
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
        paint.setStrokeWidth(10);// 画笔的宽度

//        path.addArc(200, 200, 400, 400, -225, 225);
//        path.arcTo(400, 200, 600, 400, -180, 255, false);
//        path.lineTo(400, 550);
        /**
         * Path 有两类方法，一类是直接描述路径的，另一类是辅助的设置或计算。
         */

        // 直接描述路径

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
        path.addRoundRect(50, 50, 300, 400, 10, 10, Path.Direction.CW);

        // 添加另一个path
        path2.addRect(20, 20, 200, 300, Path.Direction.CW);
        path.addPath(path2);
        canvas.drawPath(path, paint);
    }
}
