package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class ButtonListItemViewHolder extends RecyclerView.ViewHolder {
    public LinearLayout itemClick;
    public TextView ItemText;
    private TextView SubText;
    public Button ItemButton;

    public ButtonListItemViewHolder(View itemView) {
        super(itemView);

        itemClick = itemView.findViewById(R.id.Click_Item_Button_View_Btn_ID);
        ItemText = itemView.findViewById(R.id.Click_Item_Button_Text_ID);
        SubText = itemView.findViewById(R.id.Click_Item_Button_SubText_ID);
        ItemButton = itemView.findViewById(R.id.Click_Item_Button_ID);
    }

    public void setSubText(boolean visibility, String subText) {
        if (visibility) {
            SubText.setVisibility(View.VISIBLE);
            SubText.setText(subText);
        } else
            SubText.setVisibility(View.GONE);
    }

    public void setItemButtonEnable(boolean enable) {
        ItemButton.setEnabled(enable);
    }

    public void setItemButtonText(String buttonText) {
        ItemButton.setText(buttonText);
    }
}
