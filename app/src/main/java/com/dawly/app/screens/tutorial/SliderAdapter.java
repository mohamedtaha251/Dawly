package com.dawly.app.screens.tutorial;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import app.dawly.com.dawly.R;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private List<Integer> color;
    private List<Tutorial> tutorialNumber;

    public SliderAdapter(Context context, List<Integer> color, List<Tutorial> tutorials) {
        this.context = context;
        this.color = color;
        this.tutorialNumber = tutorials;
    }

    @Override
    public int getCount() {
        return color.size();
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
        Button btnNext = view.findViewById(R.id.btn_next_tutorial);
        Button btnSkip = view.findViewById(R.id.btn_skip_tutorial);
        ConstraintLayout constraintLayout = view.findViewById(R.id.constraint_layout_slider_item);

        tvHeader.setText(context.getString(tutorialNumber.get(position).getHeader()));
        tvBody.setText(context.getString(tutorialNumber.get(position).getBody()));
        ivImage.setImageResource(tutorialNumber.get(position).getImage());
        constraintLayout.setBackgroundColor(color.get(position));

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