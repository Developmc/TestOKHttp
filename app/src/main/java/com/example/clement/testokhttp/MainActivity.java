package com.example.clement.testokhttp;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhy.magicviewpager.transformer.RotateDownPageTransformer;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private int[] imgRes = {R.mipmap.head,R.mipmap.head,R.mipmap.head,R.mipmap.head,R.mipmap.head};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initData(){}
    private void initView(){
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        //设置page间隔
        viewPager.setPageMargin(20);
        //设置缓存的页面数量
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(pagerAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(imgRes[position]);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public int getCount() {
                return imgRes.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
//        viewPager.setPageTransformer(true,new AlphaPageTransformer());
        viewPager.setPageTransformer(true,new RotateDownPageTransformer());
    }
}
