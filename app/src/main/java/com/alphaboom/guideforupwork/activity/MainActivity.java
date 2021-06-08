package com.alphaboom.guideforupwork.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alphaboom.guideforupwork.R;
import com.alphaboom.guideforupwork.data.ContentNiche;
import com.alphaboom.guideforupwork.fragment.AccountFragment;
import com.alphaboom.guideforupwork.fragment.DashboardFragment;
import com.alphaboom.guideforupwork.fragment.SettingFragment;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;


public class MainActivity extends AppCompatActivity {

    private InterstitialAd interstitialAd;

    private TextView textTitleToolbar;

    private ChipNavigationBar chipNavigationBar;

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Управление Фрагментами
        chipNavigationBar = findViewById(R.id.main_ChipNavigationBar);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_dashboard, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new DashboardFragment()).commit();
        setupBottomMenu();





    }

    private void setupBottomMenu() {

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.bottom_nav_dashboard:
                        textTitleToolbar = findViewById(R.id.main_title_toolbar);
                        textTitleToolbar.setText(R.string.app_name);
                        fragment = new DashboardFragment();
                        break;
                    case R.id.bottom_nav_setting:
                        textTitleToolbar = findViewById(R.id.main_title_toolbar);
                        textTitleToolbar.setText(R.string.menu_setting);
                        fragment = new SettingFragment();
                        break;
                    case R.id.bottom_nav_account:
                        textTitleToolbar = findViewById(R.id.main_title_toolbar);
                        textTitleToolbar.setText(R.string.menu_account);
                        fragment = new AccountFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, fragment).commit();
            }
        });

    }


    // Системная кнопка "Назад"
    @Override
    public void onBackPressed(){

        // Метод слежение по нажатию, если больше двух секунд не нажали повторно то выводим сообщение о повторе
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast = Toast.makeText(getBaseContext(),R.string.main_btnSystem_back, Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }


}