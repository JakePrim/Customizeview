package com.linksu.customize_view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.linksu.customize_view.adapter.FragmentInfo;
import com.linksu.customize_view.adapter.ViewPagerAdapter;
import com.linksu.customize_view.fragment.HistogramFragment;
import com.linksu.customize_view.fragment.SectorFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        list.add(new FragmentInfo("直方图", HistogramFragment.class));
        list.add(new FragmentInfo("扇形图", SectorFragment.class));
        list.add(new FragmentInfo("圆环图", HistogramFragment.class));
        return list;
    }
}
