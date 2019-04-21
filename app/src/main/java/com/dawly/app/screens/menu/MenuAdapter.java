package com.dawly.app.screens.menu;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.Menu;
import com.dawly.app.screens.myaccount.activity.MyAccountActivity;
import com.dawly.app.views.DawlyTextViewBold;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {


    ArrayList<Menu> menuArrayList;

    FragmentManager fragmentManager;
    private Context context;

    public MenuAdapter(Context context, FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    public void setItems(ArrayList<Menu> menuArrayList) {
        this.menuArrayList = menuArrayList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_settings, viewGroup, false);
        return new MenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder menuViewHolder, int position) {
        menuViewHolder.bind(menuArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        DawlyTextViewBold itemName;
        ImageView itemImage;
        CardView menuCard;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemImage = itemView.findViewById(R.id.itemImg);
            menuCard = itemView.findViewById(R.id.menuCard);

        }

        public void bind(Menu menu) {
            itemName.setText(menu.getItemName());
            itemImage.setImageResource(menu.getImageResourceID());
            menuCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (menu.getItemName().equalsIgnoreCase("settings")) {
                        fragmentManager.beginTransaction().replace(R.id.container, new SettingsFragment()).commit();
                    }
                    if (menu.getItemName().equalsIgnoreCase("my account")) {
                        context.startActivity(new Intent(context, MyAccountActivity.class));
                    }
                }
            });


        }
    }


}
