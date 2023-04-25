package com.example.lutemongame;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;

    TextView lutemonName, lutemonAttack, lutemonDefense, lutemonHealth, lutemonExperience;
    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        lutemonName =itemView.findViewById(R.id.tvLutemonName);
        lutemonName =itemView.findViewById(R.id.tvAttack);
        lutemonName =itemView.findViewById(R.id.tvDefense);
        lutemonName =itemView.findViewById(R.id.tvHealth);
        lutemonName =itemView.findViewById(R.id.tvExperience);
    }
}
