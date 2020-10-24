package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class OnlyButtonListItemViewHolder extends RecyclerView.ViewHolder {

    public Button ItemButton;

    public OnlyButtonListItemViewHolder(View itemView) {
        super(itemView);
        ItemButton = itemView.findViewById(R.id.Click_Item_Only_Button_ID);
    }

    public void setItemButtonEnable(boolean enable)
    {
        ItemButton.setEnabled(enable);
    }

}
