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

import com.manarelsebaay.whatsApp.Activities.MainActivity;
import com.manarelsebaay.whatsApp.Adapters.CallsAdapter;
import com.manarelsebaay.whatsApp.Model.Call;
import com.manarelsebaay.whatsApp.R;

import java.util.ArrayList;

public class CallsFragment extends Fragment {
	
	private ArrayList<Call> calls;
	private RecyclerView rvCalls;
	private CallsAdapter callsAdapter;
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.calls_layout, container, false);
	}
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		
		initialize(view);
		populateCalls();
		setCallsAdapter();
		
	}
	
	private void initialize(View view) {
		rvCalls = view.findViewById(R.id.rvCalls);
		calls = new ArrayList<>();
		
	}
	
	
	private void populateCalls() {
		//Population logic goes here
		
		calls.add(new Call(MainActivity.profileUrls[0], "Manar", "9:00 PM", Call.AUDIO));
		calls.add(new Call(MainActivity.profileUrls[2], "Ahmed Bahaa", "Yesterday, 10:00 AM", Call.VIDEO));
		calls.add(new Call(MainActivity.profileUrls[1], "Mohamed", "Today, 7:00 AM", Call.VIDEO));


	}
	
	private void setCallsAdapter() {
		
		rvCalls.setLayoutManager(new LinearLayoutManager(getContext()));
		callsAdapter = new CallsAdapter(getContext(), calls);
		rvCalls.setAdapter(callsAdapter);
		
	}
	
	
}
