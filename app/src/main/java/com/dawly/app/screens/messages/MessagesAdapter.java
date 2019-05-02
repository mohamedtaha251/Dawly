package com.dawly.app.screens.messages;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.Message;
import com.dawly.app.views.DawlyTextViewBold;

import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder> {


    List<Message> messages;

    FragmentManager fragmentManager;
    private Context context;

    public MessagesAdapter(Context context, FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    public void setItems(List<Message> menuArrayList) {
        this.messages = menuArrayList;
    }

    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        View itemView;
        switch (itemType) {
            case 0:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message_me, viewGroup, false);
                return new MessagesViewHolder(itemView);
            case 1:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message, viewGroup, false);
                return new MessagesViewHolder(itemView);
            default:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message_me, viewGroup, false);
                return new MessagesViewHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder messagesViewHolder, int position) {
        messagesViewHolder.bind(messages.get(position));
    }


    @Override
    public int getItemViewType(int position) {
        switch (messages.get(position).getId()) {
            case 0:
                return 0;
            case 1:
                return 1;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MessagesViewHolder extends RecyclerView.ViewHolder {

        DawlyTextViewBold itemName;
        ImageView itemImage;
        CardView menuCard;

        public MessagesViewHolder(@NonNull View itemView) {
            super(itemView);
//            itemName = itemView.findViewById(R.id.itemName);
//            itemImage = itemView.findViewById(R.id.itemImg);
//            menuCard = itemView.findViewById(R.id.menuCard);

        }

        public void bind(Message message) {
//            menuCard.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (menu.getItemName().equalsIgnoreCase("settings")) {
//                        fragmentManager.beginTransaction().replace(R.id.container, new SettingsFragment()).commit();
//                    }
//                    if (menu.getItemName().equalsIgnoreCase("settings")) {
////                        context.startActivity(new Intent(context, MyAccount.Class));
//                    }
//                }
//            });


        }
    }


}
