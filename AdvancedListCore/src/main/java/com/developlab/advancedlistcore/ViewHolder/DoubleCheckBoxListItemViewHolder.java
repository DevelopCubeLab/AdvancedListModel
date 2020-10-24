package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class DoubleCheckBoxListItemViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout itemClick;
    public TextView ItemText;
    public TextView SubText;
    public CheckBox leftItemCheckBox;
    public CheckBox rightItemCheckBox;
    public Button ItemButton;

    public DoubleCheckBoxListItemViewHolder(View itemView) {
        super(itemView);
        itemClick = itemView.findViewById(R.id.Click_Item_Double_CheckBox_View_Btn_ID);
        ItemText = itemView.findViewById(R.id.Click_Item_Double_CheckBox_Text_ID);
        SubText = itemView.findViewById(R.id.Click_Item_Double_CheckBox_SubText_ID);
        leftItemCheckBox = itemView.findViewById(R.id.Click_Item_Double_Left_CheckBox_ID);
        rightItemCheckBox = itemView.findViewById(R.id.Click_Item_Double_Right_CheckBox_ID);
        ItemButton = itemView.findViewById(R.id.Click_Item_Double_Button_ID);
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
        leftItemCheckBox.setEnabled(enabled);
        rightItemCheckBox.setEnabled(enabled);
        ItemButton.setEnabled(enabled);
    }

}
