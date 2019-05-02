package com.dawly.app.screens.messages;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentMessagesBinding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.entities.Thread;
import com.dawly.app.screens.flights.AddFlightPaymentFragment;

import java.util.ArrayList;
import java.util.List;

public class ThreadsFragment extends BaseFragment implements View.OnClickListener {
    private FragmentMessagesBinding fragmentMessagesBinding;
    RecyclerView  messagesRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentMessagesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_messages, container, false);
        messagesRecycler = fragmentMessagesBinding.messagesRecycler;
        return fragmentMessagesBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        Thread message = new Thread();
        message.setId(0);
        Thread message1 = new Thread();
        message1.setId(1);
        List<Thread> messageList = new ArrayList<>();
        messageList.add(message);
        messageList.add(message);
        messageList.add(message1);
        messageList.add(message);
        messageList.add(message);
        messageList.add(message);
        messageList.add(message);
        messageList.add(message);


        messagesRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        messagesRecycler.setHasFixedSize(true);
        ThreadsAdapter threadsAdapter = new ThreadsAdapter(getActivity(),getActivity().getSupportFragmentManager());
        threadsAdapter.setItems(messageList);
        messagesRecycler.setAdapter(threadsAdapter);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nextBtn:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new AddFlightPaymentFragment()).commit();
                break;
        }
    }
}