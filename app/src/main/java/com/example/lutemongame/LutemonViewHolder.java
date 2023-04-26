package com.example.lutemongame;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    ImageView lutemonImage;

    TextView lutemonName, lutemonAttack, lutemonDefense, lutemonHealth, lutemonExperience;
    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonImage = itemView.findViewById(R.id.ivLutemonImage);
        lutemonName = itemView.findViewById(R.id.tvLutemonName);
        lutemonAttack = itemView.findViewById(R.id.tvAttack);
        lutemonDefense = itemView.findViewById(R.id.tvDefense);
        lutemonHealth = itemView.findViewById(R.id.tvHealth);
        lutemonExperience = itemView.findViewById(R.id.tvExperience);
    }
}
