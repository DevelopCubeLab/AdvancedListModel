package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class SwitchListItemViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout ClickItemView;
    public TextView ItemText;
    public TextView SubText;
    public Switch SwitchButton;

    public SwitchListItemViewHolder(View itemView) {
        super(itemView);

        ClickItemView = itemView.findViewById(R.id.Click_Item_Switch_View_Btn_ID);
        ItemText = itemView.findViewById(R.id.Click_Item_Switch_Text_ID);
        SubText = itemView.findViewById(R.id.Click_Item_Switch_SubText_ID);
        SwitchButton = itemView.findViewById(R.id.Click_Item_Switch_Button_ID);

    }

    public void setSubText(boolean visibility, String subText) {
        if (visibility) {
            SubText.setVisibility(View.VISIBLE);
            SubText.setText(subText);
        } else
            SubText.setVisibility(View.GONE);
    }

    public void setItemViewEnable(boolean enabled) {
        ClickItemView.setEnabled(enabled);
        ItemText.setEnabled(enabled);
        SubText.setEnabled(enabled);
        SwitchButton.setEnabled(enabled);
    }

    public void setSwitchButtonChecked(boolean selected) {
        SwitchButton.setChecked(selected);
    }

    public void setSwitchButtonToggle() {
        SwitchButton.setChecked(!SwitchButton.isChecked());
    }
}
