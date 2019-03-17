package com.dawly.app.screens.menu;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.Menu;
import com.dawly.app.views.DawlyTextViewBold;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {


    ArrayList<Menu> menuArrayList;

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
        menuViewHolder.itemName.setText(menuArrayList.get(position).getItemName());
        menuViewHolder.itemImage.setImageResource(menuArrayList.get(position).getImageResourceID());
    }

    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        DawlyTextViewBold itemName;
        ImageView itemImage;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemImage = itemView.findViewById(R.id.itemImg);

        }
    }


}
