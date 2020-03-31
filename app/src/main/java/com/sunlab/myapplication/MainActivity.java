package com.sunlab.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    FragmentHome fragmentHome = new FragmentHome();
    FragmentChatting fragmentChatting = new FragmentChatting();
    FragmentRanking fragmentRanking = new FragmentRanking();
    FragmentProfile fragmentProfile = new FragmentProfile();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentTransaction.replace(R.id.frameLayout,fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                fragmentTransaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.homeItem:
                        fragmentTransaction.replace(R.id.frameLayout,fragmentHome).commitAllowingStateLoss();
                        break;
                    case R.id.chatItem:
                        fragmentTransaction.replace(R.id.frameLayout,fragmentChatting).commitAllowingStateLoss();
                        break;
                    case R.id.rankingItem:
                        fragmentTransaction.replace(R.id.frameLayout,fragmentRanking).commitAllowingStateLoss();
                        break;
                    case R.id.profileItem:
                        fragmentTransaction.replace(R.id.frameLayout,fragmentProfile).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });
    }
}
