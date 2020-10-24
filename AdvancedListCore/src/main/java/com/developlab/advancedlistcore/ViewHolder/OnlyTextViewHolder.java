package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class OnlyTextViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public OnlyTextViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.Click_Item_Only_Text_ID);
    }

    public void setText(String text) {
        textView.setText(text);
    }
}
