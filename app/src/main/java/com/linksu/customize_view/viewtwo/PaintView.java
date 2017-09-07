package com.linksu.customize_view.viewtwo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.linksu.customize_view.R;

/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：8/18 0018
 * 描    述：paint 详解
 * 修订历史：
 * ================================================
 */
public class PaintView extends View {

    private Paint mPaint = new Paint();


    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);//开启抗锯齿
        // LinearGradient 线性渐变
        /**
         * 参数：
         * x0 y0 x1 y1：渐变的两个端点的位置
         * color0 color1 是端点的颜色
         * tile：端点范围之外的着色规则，类型是 TileMode。
         * TileMode 一共有 3 个值可选： CLAMP, MIRROR 和  REPEAT。
         * CLAMP 会在端点之外延续端点处的颜色；
         * MIRROR 是镜像模式；
         * REPEAT 是重复模式。
         */
        Shader shader = new LinearGradient(0, 250, 250, 450, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        canvas.drawCircle(250, 250, 200, mPaint);
        //注意：在设置了 Shader 的情况下， Paint.setColor/ARGB() 所设置的颜色就不再起作用。
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(30);
        canvas.drawText("线性渐变", 190, 490, mPaint);

        //RadialGradient 辐射渐变
        /**
         * 参数：
         * centerX centerY：辐射中心的坐标
         * radius：辐射半径
         * centerColor：辐射中心的颜色
         * edgeColor：辐射边缘的颜色
         * tileMode：辐射范围之外的着色模式。
         */
        Shader shader2 = new RadialGradient(800, 250, 200, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint.setShader(shader2);
        canvas.drawCircle(800, 250, 200, mPaint);
        canvas.drawText("辐射渐变", 740, 490, mPaint);

        //SweepGradient 扫描渐变
        /**
         * cx cy ：扫描的中心
         * color0：扫描的起始颜色
         * color1：扫描的终止颜色
         */
        Shader shader3 = new SweepGradient(250, 750, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"));
        mPaint.setShader(shader3);
        canvas.drawCircle(250, 750, 200, mPaint);
        canvas.drawText("辐射渐变", 190, 990, mPaint);

        // BitmapShader  Bitmap着色
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);
        /**
         * 参数：
         * bitmap：用来做模板的 Bitmap 对象
         * tileX：横向的 TileMode
         * tileY：纵向的 TileMode。
         * drawCircle() + BitmapShader 可以绘制各种不同的图片形状（其他形状同理）
         */
        Shader shader4 = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(shader4);
        canvas.drawCircle(800, 750, 200, mPaint);
        canvas.drawText("Bitmap着色", 730, 990, mPaint);

        //ComposeShader 混合着色器


    }
}
