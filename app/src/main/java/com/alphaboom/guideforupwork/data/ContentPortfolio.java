package com.alphaboom.guideforupwork.data;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alphaboom.guideforupwork.R;
import com.alphaboom.guideforupwork.activity.MainActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class ContentPortfolio extends AppCompatActivity {

    private InterstitialAd interstitialAd;

    private ImageView img;
    private Button textTitleOne, textTitleTwo, textTitleThree, textTitleFour;
    private TextView textTitleToolbar,textDescriptionOne, textDescriptionTwo, textDescriptionThree, textDescriptionFour;

    int titleToolbar, imagesPost, postTitleOne, postTitleTwo, postTitleThree, postTitleFour, postDescriptionOne, postDescriptionTwo, postDescriptionThree, postDescriptionFour;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инцилизация активити
        setContentView(R.layout.universal_content);

        // Запуск рекламы
        setupAdmod();
        // Инициализация объектов
        setupFindId();
        // Импортируем данные
        setupImportData();
        // Устанавливаем данные
        setupData();

        //Настройка кнопок с выездным текстом
        textTitleOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Если коснулся кнопки
                    textDescriptionOne.setVisibility(View.VISIBLE);
                    textDescriptionTwo.setVisibility(View.GONE);
                    textDescriptionThree.setVisibility(View.GONE);
                    textDescriptionFour.setVisibility(View.GONE);
                }

                return true;
            }
        });

        textTitleTwo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //Если коснулся кнопки
                    textDescriptionOne.setVisibility(View.GONE);
                    textDescriptionTwo.setVisibility(View.VISIBLE);
                    textDescriptionThree.setVisibility(View.GONE);
                    textDescriptionFour.setVisibility(View.GONE);
                }
                return true;
            }
        });
        textTitleThree.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //Если коснулся кнопки
                    textDescriptionOne.setVisibility(View.GONE);
                    textDescriptionTwo.setVisibility(View.GONE);
                    textDescriptionThree.setVisibility(View.VISIBLE);
                    textDescriptionFour.setVisibility(View.GONE);
                }
                return true;
            }
        });
        textTitleFour.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //Если коснулся кнопки
                    textDescriptionOne.setVisibility(View.GONE);
                    textDescriptionTwo.setVisibility(View.GONE);
                    textDescriptionThree.setVisibility(View.GONE);
                    textDescriptionFour.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });


    }

    private void setupData() {

        postTitleOne = R.string.textContentTitle_one_Portfolio;
        postDescriptionOne = R.string.textContentDescription_one_Portfolio;

        postTitleTwo = R.string.textContentTitle_two_Portfolio;
        postDescriptionTwo = R.string.textContentDescription_two_Portfolio;

        postTitleThree = R.string.textContentTitle_three_Portfolio;
        postDescriptionThree = R.string.textContentDescription_three_Portfolio;

        postTitleFour = R.string.textContentTitle_four_Portfolio;
        postDescriptionFour = R.string.textContentDescription_four_Portfolio;

        // Данные с Импорта
        textTitleToolbar.setText(titleToolbar);
        img.setImageResource(imagesPost);
        //

        textTitleOne.setText(postTitleOne);
        textDescriptionOne.setText(postDescriptionOne);
        textTitleTwo.setText(postTitleTwo);
        textDescriptionTwo.setText(postDescriptionTwo);
        textTitleThree.setText(postTitleThree);
        textDescriptionThree.setText(postDescriptionThree);
        textTitleFour.setText(postTitleFour);
        textDescriptionFour.setText(postDescriptionFour);

    }

    private void setupImportData() {

        Intent intent = getIntent();

        titleToolbar = intent.getExtras().getInt("titlePortfolio");
        imagesPost = intent.getExtras().getInt("imgPortfolio");

    }

    private void setupFindId() {

        img = findViewById(R.id.universal_content_img);
        img.setClipToOutline(true);

        textTitleToolbar = findViewById(R.id.universal_TitleToolbar);

        textTitleOne = findViewById(R.id.universal_content_TitleOne);
        textTitleTwo = findViewById(R.id.universal_content_TitleTwo);
        textTitleThree = findViewById(R.id.universal_content_TitleThree);
        textTitleFour = findViewById(R.id.universal_content_TitleFour);

        textDescriptionOne = findViewById(R.id.universal_content_DescriptionOne);
        textDescriptionTwo = findViewById(R.id.universal_content_DescriptionTwo);
        textDescriptionThree = findViewById(R.id.universal_content_DescriptionThree);
        textDescriptionFour = findViewById(R.id.universal_content_DescriptionFour);

    }

    public void setupAdmod() {
        // Реклама
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.admob_unit_id));
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
        // Реклама на экран
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

    }

    // Системная кнопка "Назад"
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(ContentPortfolio.this, MainActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){}
    }
}