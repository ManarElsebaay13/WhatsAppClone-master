package com.manarelsebaay.whatsApp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.manarelsebaay.whatsApp.Fragments.CallsFragment;
import com.manarelsebaay.whatsApp.Fragments.CameraFragment;
import com.manarelsebaay.whatsApp.Fragments.ChatsFragment;
import com.manarelsebaay.whatsApp.Fragments.StatusFragment;

public class PagerAdapter extends FragmentPagerAdapter {
	
	public PagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	@Override
	public Fragment getItem(int i) {
		switch (i) {
			case 0:
				return new CameraFragment();
			case 1:
				return new ChatsFragment();
			case 2:
				return new StatusFragment();
			case 3:
				return new CallsFragment();
		}
		return null;
	}
	
	@Override
	public int getCount() {
		return 4;
	}
}
