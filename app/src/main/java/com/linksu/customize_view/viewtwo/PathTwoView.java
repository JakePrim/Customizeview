package com.linksu.customize_view.viewtwo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.linksu.customize_view.R;

/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：9/7 0007
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class PathTwoView extends View {
    private Paint mPaint = new Paint();

    public PathTwoView(Context context) {
        super(context);
    }

    public PathTwoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathTwoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPaint.setAntiAlias(true);//开启抗锯齿
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Shader shader1 = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        // 第二个 Shader：从上到下的线性渐变（由透明到黑色）
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
        Shader shader2 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        // ComposeShader：结合两个 Shader
        Shader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.DST_OUT);
        mPaint.setShader(shader);
        canvas.drawCircle(300, 300, 300, mPaint);
    }
}
