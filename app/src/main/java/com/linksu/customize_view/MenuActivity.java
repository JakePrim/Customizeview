package com.linksu.customize_view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：8/21 0021
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void baseView(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void paintView(View v) {
        Intent intent = new Intent(this, PaintActivity.class);
        startActivity(intent);
    }

    public void textView(View v) {
        Intent intent = new Intent(this, DrawTextActivity.class);
        startActivity(intent);
    }
}
