package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class SingleCheckBoxViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout itemClick;
    public TextView ItemText;
    public CheckBox ItemCheckBox;

    public SingleCheckBoxViewHolder(View itemView) {
        super(itemView);
        itemClick = itemView.findViewById(R.id.Click_Single_Item_View_Btn_ID);
        ItemText = itemView.findViewById(R.id.Click_Single_Item_Text_ID);
        ItemCheckBox = itemView.findViewById(R.id.Click_Single_Item_CheckBox_ID);
    }

    public void setItemCheckBoxVisibility(boolean visibility) {
        if (visibility)
            ItemCheckBox.setVisibility(View.VISIBLE);
        else
            ItemCheckBox.setVisibility(View.GONE);
    }

    public void setItemViewEnable(boolean enabled) {
        itemClick.setEnabled(enabled);
        ItemText.setEnabled(enabled);
        ItemCheckBox.setEnabled(enabled);
    }

    public void setItemCheckBoxChecked(boolean checked) {
        ItemCheckBox.setChecked(checked);
    }
}
