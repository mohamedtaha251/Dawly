package com.dawly.app.screens.tutorial;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import app.dawly.com.dawly.R;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private List<Tutorial> tutorials;

    public SliderAdapter(Context context, List<Tutorial> tutorials) {
        this.context = context;
        this.tutorials = tutorials;
    }

    @Override
    public int getCount() {
        return tutorials.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_slider, null);

        TextView tvHeader = view.findViewById(R.id.tv_tutorial_header);
        TextView tvBody = view.findViewById(R.id.tv_tutorial_body);
        ImageView ivImage = view.findViewById(R.id.tutorial_image);


        tvHeader.setText(context.getString(tutorials.get(position).getHeader()));
        tvBody.setText(context.getString(tutorials.get(position).getBody()));
        ivImage.setImageResource(tutorials.get(position).getImage());

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);


        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}