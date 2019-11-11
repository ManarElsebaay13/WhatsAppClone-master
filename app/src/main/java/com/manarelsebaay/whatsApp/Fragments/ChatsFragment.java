package com.manarelsebaay.whatsApp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.manarelsebaay.whatsApp.Activities.MainActivity;
import com.manarelsebaay.whatsApp.Adapters.ChatsAdapter;
import com.manarelsebaay.whatsApp.Model.Chat;
import com.manarelsebaay.whatsApp.R;

import java.util.ArrayList;

public class ChatsFragment extends Fragment {
	
	private ArrayList<Chat> chats;
	
	private RecyclerView rvChats;
	private ChatsAdapter adapter;
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.chats_layout, container, false);
	}
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		initialize(view);
		populateChats();
		setAdapter();


		
	}


	private void initialize(View view) {
		
		chats = new ArrayList<>();
		rvChats = view.findViewById(R.id.rvChats);
		
	}
	
	private void populateChats() {
		//Population logic goes here
		
		chats.add(new Chat(MainActivity.profileUrls[0], "Manar", "Working !", "9:15 PM"));
		chats.add(new Chat(MainActivity.profileUrls[1],"Mohammed ", "What you are doing, Really Iam going.", "5.01 PM"));
		chats.add(new Chat(MainActivity.profileUrls[2], "Ahmed Bahaa ", "Hello ", "5:00 PM"));
		chats.add(new Chat(MainActivity.profileUrls[3], "Marwa Mohammed", "well", "so we can do it."));
		chats.add(new Chat(MainActivity.profileUrls[4]," Ahmed Adel ", "What about you", "3/11/17"));
		chats.add(new Chat(MainActivity.profileUrls[5],"Ramadan", "my sister who dii this", "13/1/17"));
		chats.add(new Chat(MainActivity.profileUrls[6],"khaled", "sure Iaam coming", "11/20/19"));
		chats.add(new Chat(MainActivity.profileUrls[7], " menna", "I'm going to the cinema today .", "5/22/19"));
		
	}
	
	private void setAdapter() {
		
		adapter = new ChatsAdapter(getContext(), chats);
		rvChats.setLayoutManager(new LinearLayoutManager(getContext()));
		rvChats.setAdapter(adapter);
	}



	
	
}
