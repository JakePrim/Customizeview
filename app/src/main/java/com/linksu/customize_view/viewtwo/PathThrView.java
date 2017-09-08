package com.linksu.customize_view.viewtwo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.EmbossMaskFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.icu.text.CollationKey;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.linksu.customize_view.R;

/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：9/7 0007
 * 描    述：ColorFilter
 * 修订历史：
 * ================================================
 */
public class PathThrView extends View {
    private Paint mPaint = new Paint();

    public PathThrView(Context context) {
        super(context);
    }

    public PathThrView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathThrView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);//关闭硬件加速
//        mPaint.setAntiAlias(true);//开启抗锯齿
//        mPaint.setTextSize(40);
//        mPaint.setDither(true);//设置图像的抖动
//        mPaint.setFilterBitmap(true);//设置是否使用双线性过滤来绘制 Bitmap,设置双线性过滤来优化 Bitmap 放大绘制的效果
        /**
         * radius 是阴影的模糊范围；dx dy 是阴影的偏移量；shadowColor 是阴影的颜色。
         * 绘制内容下面加一层阴影
         * 如果要清除阴影层，使用 clearShadowLayer() 。
         * 注意：
         * 在硬件加速开启的情况下， setShadowLayer() 只支持文字的绘制，文字之外的绘制必须关闭硬件加速才能正常绘制阴影。
         * 如果 shadowColor 是半透明的，阴影的透明度就使用 shadowColor 自己的透明度；
         * 而如果 shadowColor 是不透明的，阴影的透明度就使用 paint 的透明度。
         */
//        mPaint.setShadowLayer(10, 0, 0, Color.RED);//绘制内容下面加一层阴影

        //BlurMaskFilter  模糊效果的 MaskFilter
        /**
         * 注意:需要开启硬件加速
         * radius 参数是模糊的范围
         *
         * style 是模糊的类型。一共有四种：
         * NORMAL: 内外都模糊绘制
         * SOLID: 内部正常绘制，外部模糊
         * INNER: 内部模糊，外部不绘制
         * OUTER: 内部不绘制，外部模糊
         */
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        canvas.drawBitmap(bitmap, 100, 100, mPaint);

        //EmbossMaskFilter 浮雕效果
        /**
         *  direction 是一个 3 个元素的数组，指定了光源的方向；
         *  ambient 是环境光的强度，数值范围是 0 到 1；
         *  specular 是炫光的系数；
         *  blurRadius 是应用光线的范围
         */
        mPaint.setMaskFilter(new EmbossMaskFilter(new float[]{0, 1, 1}, 0.2f, 8, 10));
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        canvas.drawBitmap(bitmap2, 500, 500, mPaint);

//        Shader shader1 = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        mPaint.setShader(shader1);
//
//        //LightingColorFilter 模拟简单的光照效果的
//        ColorFilter lightingColor = new LightingColorFilter(0x00ffff, 0x000000);
//        mPaint.setColorFilter(lightingColor);
//        canvas.drawCircle(300, 300, 300, mPaint);
//        canvas.drawText("模拟光照效果", 200, 650, mPaint);


    }
}
