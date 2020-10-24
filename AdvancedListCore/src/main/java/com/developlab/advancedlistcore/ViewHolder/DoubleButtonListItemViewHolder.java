package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class DoubleButtonListItemViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout itemClick;
    public TextView ItemText;
    public TextView SubText;
    public Button leftItemButton;
    public Button rightItemButton;

    public DoubleButtonListItemViewHolder(View itemView) {
        super(itemView);
        itemClick = itemView.findViewById(R.id.Click_Item_Double_Button_View_Btn_ID);
        ItemText = itemView.findViewById(R.id.Click_Item_Double_Button_Text_ID);
        SubText = itemView.findViewById(R.id.Click_Item_Double_Button_SubText_ID);
        leftItemButton = itemView.findViewById(R.id.Click_Item_Double_Left_Button_ID);
        rightItemButton = itemView.findViewById(R.id.Click_Item_Double_Right_Button_ID);
    }

    public void setSubText(boolean visibility, String subText) {
        if (visibility) {
            SubText.setVisibility(View.VISIBLE);
            SubText.setText(subText);
        } else
            SubText.setVisibility(View.GONE);
    }

    public void setItemViewEnable(boolean enabled) {
        itemClick.setEnabled(enabled);
        ItemText.setEnabled(enabled);
        SubText.setEnabled(enabled);
        leftItemButton.setEnabled(enabled);
        rightItemButton.setEnabled(enabled);
    }
}
