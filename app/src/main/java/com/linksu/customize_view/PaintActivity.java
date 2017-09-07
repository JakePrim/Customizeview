package com.linksu.customize_view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.linksu.customize_view.adapter.FragmentInfo;
import com.linksu.customize_view.adapter.ViewPagerAdapter;
import com.linksu.customize_view.fragment.HartFragment;
import com.linksu.customize_view.fragment.HistogramFragment;
import com.linksu.customize_view.fragment.RingFragment;
import com.linksu.customize_view.fragment.SectorFragment;
import com.linksu.customize_view.fragmentTwo.BasePaintFragment;
import com.linksu.customize_view.fragmentTwo.PaintTwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：8/21 0021
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class PaintActivity extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        initTablayout();
    }

    private void initTablayout() {
        PagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), initFragments());
        viewpager.setOffscreenPageLimit(adapter.getCount());
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }

    private List<FragmentInfo> initFragments() {
        List<FragmentInfo> list = new ArrayList<>();
        list.add(new FragmentInfo("渐变", BasePaintFragment.class));
        list.add(new FragmentInfo("混合着色器", PaintTwoFragment.class));
        return list;
    }
}
