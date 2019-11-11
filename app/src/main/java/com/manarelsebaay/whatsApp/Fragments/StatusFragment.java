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
import com.manarelsebaay.whatsApp.Adapters.StatusAdapter;
import com.manarelsebaay.whatsApp.Model.Status;
import com.manarelsebaay.whatsApp.R;

import java.util.ArrayList;

public class StatusFragment extends Fragment {
	
	private RecyclerView rvStatus;
	private StatusAdapter adapter;
	private ArrayList<Status> statusList;
	
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.status_layout, container, false);
	}
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		initialize(view);
		populateStatus();
		setAdapter();
		
	}
	
	private void initialize(View view) {
		
		statusList = new ArrayList<>();
		rvStatus = view.findViewById(R.id.rvStatus);
		
	}
	
	private void populateStatus() {
		//Population logic goes here
		
		statusList.add(new Status(MainActivity.profileUrls[1], "Mohamed", "14 minutes ago"));
		statusList.add(new Status(MainActivity.profileUrls[4], "Ahmed Adel", "10 minutes ago"));
		statusList.add(new Status(MainActivity.profileUrls[0], "Manar", "Yesterday, 5:08 PM"));
		statusList.add(new Status(MainActivity.profileUrls[5], "Ramadan", "Today, 10:30 AM"));
		
	}
	
	private void setAdapter() {
		
		rvStatus.setLayoutManager(new LinearLayoutManager(getContext()));
		adapter = new StatusAdapter(getContext(), statusList);
		
		rvStatus.setAdapter(adapter);
		
	}
	
	
}
