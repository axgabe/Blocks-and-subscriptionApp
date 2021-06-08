package com.alphaboom.guideforupwork.fragment;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alphaboom.guideforupwork.R;
import com.alphaboom.guideforupwork.data.ContentClients;
import com.alphaboom.guideforupwork.data.ContentCommunication;
import com.alphaboom.guideforupwork.data.ContentCompetitors;
import com.alphaboom.guideforupwork.data.ContentMindset;
import com.alphaboom.guideforupwork.data.ContentModel;
import com.alphaboom.guideforupwork.data.ContentNiche;
import com.alphaboom.guideforupwork.data.ContentPortfolio;
import com.alphaboom.guideforupwork.subscription.SubsManeger;


public class DashboardFragment extends Fragment {

    private SharedPreferences sharedPreferences;

    private LinearLayout linearLayoutNiche1, linearLayoutClients2, linearLayoutCompetitors3,
            linearLayoutPortfolio4, linearLayoutCommunication5, linearLayoutMindset6;

    private TextView titleNiche, titleClients, titleCompetitors, titlePortfolio, titleCommunication, titleMindset;
    private int textTitleNiche, textTitleClients, textTitleCompetitors, textTitlePortfolio, textTitleCommunication, textTitleMindset;

    private ImageView imgNiche, imgClients, imgCompetitors, imgPortfolio, imgCommunication, imgMindset;
    private int imgBackgroundNiche1, imgBackgroundClients2, imgBackgroundCompetitors3, imgBackgroundPortfolio4, imgBackgroundCommunication5, imgBackgroundMindset6;

    private ContentModel contentModel, contentModel2, contentModel3, contentModel4, contentModel5, contentModel6;

    private Dialog dialogSubscription;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Раздуваем макет для этого фрагмента
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_dashboard, container, false);

        //Метод добавление обектов для вывода информакции на экран.
        setupFindId(root);

        setupData();

        setupClickAndExportData();




        return  root;

    }

    private void setupData() {

        textTitleNiche = R.string.category_niche;
        imgBackgroundNiche1 = R.drawable.category_niche_1;
        imgNiche.setImageResource(imgBackgroundNiche1);
        imgNiche.setClipToOutline(true);
        titleNiche.setText(textTitleNiche);

        textTitleClients = R.string.category_clients;
        imgBackgroundClients2 = R.drawable.category_clients_2;
        imgClients.setImageResource(imgBackgroundClients2);
        imgClients.setClipToOutline(true);
        titleClients.setText(textTitleClients);

        textTitleCompetitors = R.string.category_competitors;
        imgBackgroundCompetitors3 = R.drawable.category_competitors_3;
        imgCompetitors.setImageResource(imgBackgroundCompetitors3);
        imgCompetitors.setClipToOutline(true);
        titleCompetitors.setText(textTitleCompetitors);

        textTitlePortfolio = R.string.category_portfolio;
        imgBackgroundPortfolio4 = R.drawable.category_portfolio_4;
        imgPortfolio.setImageResource(imgBackgroundPortfolio4);
        imgPortfolio.setClipToOutline(true);
        titlePortfolio.setText(textTitlePortfolio);

        textTitleCommunication = R.string.category_communication;
        imgBackgroundCommunication5 = R.drawable.category_communication_5_close;
        imgCommunication.setImageResource(imgBackgroundCommunication5);
        imgCommunication.setClipToOutline(true);
        titleCommunication.setText(textTitleCommunication);

        textTitleMindset = R.string.category_mindset;
        imgBackgroundMindset6 = R.drawable.category_mindset_6_close;
        imgMindset.setImageResource(imgBackgroundMindset6);
        imgMindset.setClipToOutline(true);
        titleMindset.setText(textTitleMindset);


    }

    private void setupFindId(ViewGroup root) {

        linearLayoutNiche1 = root.findViewById(R.id.dashboard_container_category_Niche);
        linearLayoutClients2 = root.findViewById(R.id.dashboard_container_category_Clients);
        linearLayoutCompetitors3 = root.findViewById(R.id.dashboard_container_category_Competitors);
        linearLayoutPortfolio4 = root.findViewById(R.id.dashboard_container_category_Portfolio);
        linearLayoutCommunication5 = root.findViewById(R.id.dashboard_container_category_Communication);
        linearLayoutMindset6 = root.findViewById(R.id.dashboard_container_category_Mindset);

        imgNiche = root.findViewById(R.id.dashboard_container_category_img_Niche);
        titleNiche = root.findViewById(R.id.dashboard_container_category_title_Niche);

        imgClients = root.findViewById(R.id.dashboard_container_category_img_Clients);
        titleClients = root.findViewById(R.id.dashboard_container_category_title_Clients);

        imgCompetitors = root.findViewById(R.id.dashboard_container_category_img_Competitors);
        titleCompetitors = root.findViewById(R.id.dashboard_container_category_title_Competitors);

        imgPortfolio = root.findViewById(R.id.dashboard_container_category_img_Portfolio);
        titlePortfolio = root.findViewById(R.id.dashboard_container_category_title_Portfolio);

        imgCommunication = root.findViewById(R.id.dashboard_container_category_img_Communication);
        titleCommunication = root.findViewById(R.id.dashboard_container_category_title_Communication);

        imgMindset = root.findViewById(R.id.dashboard_container_category_img_Mindset);
        titleMindset = root.findViewById(R.id.dashboard_container_category_title_Mindset);

    }

    private void setupClickAndExportData() {

        // Процес сохранения подписки
        sharedPreferences = this.getActivity().getSharedPreferences("Save_content", Context.MODE_PRIVATE);
        final int subscriptionSharedPreferences = sharedPreferences.getInt("subscription", 1);

        //Метод замены серых изображений на яркие, после оформление подписки
        if (subscriptionSharedPreferences >= 2){
            imgBackgroundCommunication5 = R.drawable.category_communication_5;
            imgBackgroundMindset6 = R.drawable.category_mindset_6;


            imgCommunication.setImageResource(imgBackgroundCommunication5);
            imgCommunication.setClipToOutline(true);

            imgMindset.setImageResource(imgBackgroundMindset6);
            imgMindset.setClipToOutline(true);

        }

        // Подготавливаем материал к Экспорту
        contentModel = new ContentModel(textTitleNiche, imgBackgroundNiche1);
        contentModel2 = new ContentModel(textTitleClients,imgBackgroundClients2);
        contentModel3 = new ContentModel(textTitleCompetitors, imgBackgroundCompetitors3);
        contentModel4 = new ContentModel(textTitlePortfolio, imgBackgroundPortfolio4);
        contentModel5 = new ContentModel(textTitleCommunication, imgBackgroundCommunication5);
        contentModel6 = new ContentModel(textTitleMindset, imgBackgroundMindset6);



        linearLayoutNiche1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            try {
                Intent intent = new Intent(getActivity(), ContentNiche.class);


                intent.putExtra("titleNiche", contentModel.getCategoryTitle());
                intent.putExtra("imgNiche", contentModel.getImg());

                startActivity(intent);

            }catch (Exception e){}

            }
        });

        linearLayoutClients2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(getActivity(), ContentClients.class);


                    intent.putExtra("titleClients", contentModel2.getCategoryTitle());
                    intent.putExtra("imgClients", contentModel2.getImg());

                    startActivity(intent);

                }catch (Exception e){}

            }
        });

        linearLayoutCompetitors3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(getActivity(), ContentCompetitors.class);


                    intent.putExtra("titleCompetitors", contentModel3.getCategoryTitle());
                    intent.putExtra("imgCompetitors", contentModel3.getImg());

                    startActivity(intent);

                }catch (Exception e){}

            }
        });

        linearLayoutPortfolio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(getActivity(), ContentPortfolio.class);

                    intent.putExtra("titlePortfolio", contentModel4.getCategoryTitle());
                    intent.putExtra("imgPortfolio", contentModel4.getImg());

                    startActivity(intent);

                }catch (Exception e){}

            }
        });

        linearLayoutCommunication5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContentCommunication.class);

                if (subscriptionSharedPreferences >= 2) {

                    intent.putExtra("titleCommunication", contentModel5.getCategoryTitle());
                    intent.putExtra("imgCommunication", contentModel5.getImg());

                    startActivity(intent);

                }else{
                    imgBackgroundCommunication5 = R.drawable.category_communication_5;
                    contentModel5 = new ContentModel(textTitleCommunication, imgBackgroundCommunication5);
                    intent.putExtra("titleCommunication", contentModel5.getCategoryTitle());
                    intent.putExtra("imgCommunication", contentModel5.getImg());

                    DialogSubscription(intent);
                    dialogSubscription.show();
                }
            }
        });

        linearLayoutMindset6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SubsManeger.class);

                if (subscriptionSharedPreferences >= 2) {

                    intent.putExtra("titleMindset", contentModel6.getCategoryTitle());
                    intent.putExtra("imgMindset", contentModel6.getImg());

                    startActivity(intent);

                }else{
                    imgBackgroundMindset6 = R.drawable.category_mindset_6;
                    contentModel6 = new ContentModel(textTitleMindset, imgBackgroundMindset6);
                    intent.putExtra("titleMindset", contentModel6.getCategoryTitle());
                    intent.putExtra("imgMindset", contentModel6.getImg());

                    DialogSubscription(intent);
                    dialogSubscription.show();
                }


            }
        });


    }


    private void DialogSubscription (Intent intent){

        dialogSubscription = new Dialog(getContext());
        dialogSubscription.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogSubscription.setContentView(R.layout.item_subscription);
        dialogSubscription.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogSubscription.setCancelable(false);

        TextView subscriptionBtnClose = dialogSubscription.findViewById(R.id.subscription_btn_close);
        subscriptionBtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialogSubscription.dismiss();
                }catch (Exception e){}

            }
        });

        Button subscriptionBtnCheckout = dialogSubscription.findViewById(R.id.subscription_btn_checkout);
        subscriptionBtnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("subscription", 2);
                    editor.commit();
                    startActivity(intent);

                }catch (Exception e){}

            }
        });



    }


}