package com.manarelsebaay.whatsApp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.manarelsebaay.whatsApp.Adapters.PagerAdapter;
import com.manarelsebaay.whatsApp.R;

public class MainActivity extends AppCompatActivity {
	
	private static final String TAG = "MainActivity";
	
	//Random image urls
	public static final String[] profileUrls = {
			"https://makehimyours.com.au/wp-content/uploads/2016/11/Depositphotos_9830876_l-2015Optimised.jpg",
		   "https://i.pinimg.com/originals/7d/1a/3f/7d1a3f77eee9f34782c6f88e97a6c888.jpg",
		   "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjLxbeqrrVDjVNh-ZqZFoA2MuIrMOW3aC9zqr5f0bH9I80q_FV&s",
		   "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSO1Awoj9EJMFEIRo0EAs6GnR4Xsulbgefvh6XFVckdPA43yarwUw&s",
			"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSdL1s1tMcbRkQm2VhwJUVrKmFTAqm4FprzAtAMONpZVTkFjFPlA&s"
			,"https://scx1.b-cdn.net/csz/news/800/2018/whydosomanyp.jpg"
			,"https://media.istockphoto.com/videos/profile-of-a-woman-breathing-fresh-air-at-sunset-video-id1094955902?s=640x640"
			,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTad_ldxetRvh_GopiCrPJ_4K324pF-HiE2nNTCjoTlIUhtDoJ7&s"
	};
	
	private Toolbar toolbar;
	
	private FloatingActionButton mainFab;
	private FloatingActionButton miniFab;
	
	private ViewPager viewPager;
	private TabLayout tabLayout;
	
	private PagerAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
			setTheme(R.style.App_Dark);
		}
		setContentView(R.layout.activity_main);
		
		initialize();
		setUpViewPager();
		
	}
	private void initialize() {
		
		toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		tabLayout = findViewById(R.id.tablayout);
		viewPager = findViewById(R.id.viewpager);
		
		mainFab = findViewById(R.id.mainFab);
		miniFab = findViewById(R.id.miniFab);
		
		miniFab.setVisibility(View.GONE);               //Default
	}
	
	private void setUpViewPager() {
		
		adapter = new PagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		
		
		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
		viewPager.setCurrentItem(1);            //Default selection is chats screen
		
		tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				
				if (viewPager.getCurrentItem() != tab.getPosition()) {
					//Loading appropriate fragment just in case
					viewPager.setCurrentItem(tab.getPosition());
				}
				
				if (tab.getPosition() == 0) {   //Camera Fragment
					tab.setIcon(getResources().getDrawable(R.drawable.ic_action_camera));
					
					miniFab.setVisibility(View.GONE);
					mainFab.setVisibility(View.GONE);
					
				} else if (tab.getPosition() == 1) {    //Chats Fragment
					
					miniFab.setVisibility(View.GONE);
					mainFab.setVisibility(View.VISIBLE);
					mainFab.setImageResource(R.drawable.ic_message);
					
				} else if (tab.getPosition() == 2) {    //Status Fragment
					
					miniFab.setVisibility(View.VISIBLE);
					mainFab.setVisibility(View.VISIBLE);
					mainFab.setImageResource(R.drawable.ic_photo_camera);
					
				} else if (tab.getPosition() == 3) {    //Calls Fragment
					
					miniFab.setVisibility(View.GONE);
					mainFab.setVisibility(View.VISIBLE);
					mainFab.setImageResource(R.drawable.ic_call);
					
				}
				
				
			}
			
			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
				if (tab.getPosition() == 0) {
					tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_action_camera_unselected));
				}
			}
			
			@Override
			public void onTabReselected(TabLayout.Tab tab) {
			
			}
		});
		
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mainscreen_menu, menu);
		
		//Updating Toolbar icon according to the Theme
		MenuItem item = menu.findItem(R.id.imgDarkMode);
		if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
			item.setIcon(R.drawable.ic_day);
		} else {
			item.setIcon(R.drawable.ic_night);
		}
		
		return super.onCreateOptionsMenu(menu);
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
			case R.id.imgDarkMode:
				toggleTheme();
				break;
			
			
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void toggleTheme() {
		
		if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
			AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
		} else {
			AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
		}
		
		this.finish();
		startActivity(new Intent(this, this.getClass()));
		
	}








}
