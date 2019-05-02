package com.dawly.app.views;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BottomNavigation extends BottomNavigationView {
    public BottomNavigation(Context context) {
        super(context);
    }

    public BottomNavigation(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomNavigation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setSelected(int index) {
        try {
            Field f = BottomNavigationView.class.getDeclaredField("mMenuView");
            f.setAccessible(true);
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) f.get(this);

            try {
                Method method = menuView.getClass().getDeclaredMethod("activateNewButton", Integer.TYPE);
                method.setAccessible(true);
                method.invoke(menuView, index);
            } catch (SecurityException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
