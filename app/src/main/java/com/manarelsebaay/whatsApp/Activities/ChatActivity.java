package com.manarelsebaay.whatsApp.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.manarelsebaay.whatsApp.Fragments.ChatFragment;
import com.manarelsebaay.whatsApp.R;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        displayFragment(new ChatFragment());

        init();
    }



    private void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
    private void init() {
        initView();
    }

    private void initView() {

    }

}
