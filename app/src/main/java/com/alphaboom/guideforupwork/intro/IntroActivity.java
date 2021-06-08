package com.alphaboom.guideforupwork.intro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.alphaboom.guideforupwork.activity.MainActivity;
import com.alphaboom.guideforupwork.R;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private IntroAdapter introAdapter;
    private LinearLayout layoutIntroIndicator;
    private Button btnIntroNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Активити на весь экран
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        // Делаем проверку было ли раньше у пользователя окно приведствия
        if (restorePrefData()){
            try {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }catch (Exception e){}
        }


        // Добавляем наши обекты с ИнтроАктивити
        layoutIntroIndicator = findViewById(R.id.intro_indicator);
        btnIntroNext = findViewById(R.id.intro_btn);


        //Метод добавление обектов для вывода информакции на экран.
        setupIntroItem();

        final ViewPager2 introViewPager2 = findViewById(R.id.introViewPager2);
        introViewPager2.setAdapter(introAdapter);

        // Индикатор отслеживание окон
        setupIntroIndicator();

        // Индикатор отслеживание открытых окон
        setCurrentIntroIndicator(0);


        // Индикатор отслеживание открытых окон отслеживание действий
        introViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIntroIndicator(position);
            }
        });


        // Обробатываем кнопку "Далее"
        btnIntroNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(introViewPager2.getCurrentItem() + 1 < introAdapter.getItemCount()){
                    introViewPager2.setCurrentItem(introViewPager2.getCurrentItem() + 1);
                } else {
                    try {

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        //Сохраняем данные о просмотре интро
                        savePrefsData();
                        finish();
                    }catch (Exception e){}
                }
            }
        });


    }



    private void setCurrentIntroIndicator(int index) {

        int childCount = layoutIntroIndicator.getChildCount();

        for (int i = 0; i < childCount; i++){
            ImageView imageView = (ImageView) layoutIntroIndicator.getChildAt(i);
            if (i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                                getApplicationContext(), R.drawable.intro_indicator_selected
                        )
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.intro_indicator_default)
                );
            }

        }
        // Конец циклу
        // Изменяем название кнопки при последнем окне
        if (index == introAdapter.getItemCount()-1){
            btnIntroNext.setText(R.string.intro_btn_begin);
        }else {
            btnIntroNext.setText(R.string.intro_btn_next);
        }

    }

    // Установка индикатора слежения за вкладками присваивание движения.
    private void setupIntroIndicator() {

        ImageView[] indicators = new ImageView[introAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );

        layoutParams.setMargins(8,0,8,0);

        for (int i = 0; i < indicators.length; i++){

            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.intro_indicator_default
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutIntroIndicator.addView(indicators[i]);

        }
    }

    private void setupIntroItem() {

        List<IntroModel> introModels = new ArrayList<>();

        introModels.add(new IntroModel(R.string.intro_title_one,R.string.intro_description_one,R.drawable.ic_launcher_foreground));

        introModels.add(new IntroModel(R.string.intro_title_two,R.string.intro_description_two,R.drawable.ic_launcher_foreground));

        introAdapter = new IntroAdapter(introModels);

    }



    // Сохранине действий пользовотеля
    private boolean restorePrefData (){

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened", false);
        return isIntroActivityOpenedBefore;

    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();
    }


}
