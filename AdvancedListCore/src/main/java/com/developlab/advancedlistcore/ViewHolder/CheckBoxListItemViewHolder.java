package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class CheckBoxListItemViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout itemClick;
    public TextView ItemText;
    private TextView SubText;
    public CheckBox CheckBox;

    public CheckBoxListItemViewHolder(View itemView) {
        super(itemView);
        itemClick = itemView.findViewById(R.id.Click_Item_CheckBox_View_Btn_ID);
        ItemText = itemView.findViewById(R.id.Click_Item_CheckBox_Text_ID);
        SubText = itemView.findViewById(R.id.Click_Item_CheckBox_SubText_ID);
        CheckBox = itemView.findViewById(R.id.Click_Item_CheckBox_ID);
    }

    public void setSubText(boolean visibility, String subText) {
        if (visibility) {
            SubText.setVisibility(View.VISIBLE);
            SubText.setText(subText);
        } else
            SubText.setVisibility(View.GONE);
    }

    public void setCheckBoxChecked(boolean checked) {
        CheckBox.setChecked(checked);
    }

    public boolean getCheckBoxIsChecked() {
        return CheckBox.isChecked();
    }

    public void setItemEnable(boolean enabled) {
        itemClick.setEnabled(enabled);
        ItemText.setEnabled(enabled);
        SubText.setEnabled(enabled);
        CheckBox.setEnabled(enabled);
    }
}
