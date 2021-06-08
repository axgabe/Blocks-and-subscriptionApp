package com.alphaboom.guideforupwork.intro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alphaboom.guideforupwork.R;

import java.util.List;

public class IntroAdapter extends RecyclerView.Adapter<IntroAdapter.IntroViewHolder> {

    private List<IntroModel> introModels;

    public IntroAdapter(List<IntroModel> introModels){
        this.introModels = introModels;
    }

    @NonNull
    @Override
    public IntroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IntroViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_intro_container, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull IntroViewHolder holder, int position) {
        holder.setIntroData(introModels.get(position));
    }

    @Override
    public int getItemCount() {
        return introModels.size();
    }

    // Инцилизация обьектов
    class IntroViewHolder extends RecyclerView.ViewHolder{

        private TextView textTitle;
        private TextView textDescription;
        private ImageView introImage;

        IntroViewHolder(@NonNull View itemView) {
            super(itemView);

            //Находим обьекты
            textTitle = itemView.findViewById(R.id.intro_item_textTitle);
            textDescription = itemView.findViewById(R.id.intro_item_textDescription);
            introImage = itemView.findViewById(R.id.intro_item_img);
        }

        void setIntroData (IntroModel introModel){

            // Присваивание обьектов к модели
            textTitle.setText(introModel.getTitle());
            textDescription.setText(introModel.getDescription());
            introImage.setImageResource(introModel.getImg());

        }
    }


}
