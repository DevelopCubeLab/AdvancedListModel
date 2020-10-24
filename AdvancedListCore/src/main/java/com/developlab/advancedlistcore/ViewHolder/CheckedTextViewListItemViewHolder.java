package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class CheckedTextViewListItemViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout itemClick;
    public TextView ItemText;
    private TextView SubText;
    private CheckedTextView ItemCheckedText;

    public CheckedTextViewListItemViewHolder(View itemView) {

        super(itemView);
        itemClick = itemView.findViewById(R.id.Click_Item_CheckBox_View_Btn_ID);
        ItemText = itemView.findViewById(R.id.Click_Item_CheckBox_Text_ID);
        SubText = itemView.findViewById(R.id.Click_Item_CheckBox_SubText_ID);
        ItemCheckedText = itemView.findViewById(R.id.Click_Item_CheckedTextViewBox_ID);

    }

    public void setItemClick(boolean value) {
        ItemText.setSelected(value);
        ItemCheckedText.setChecked(value);
    }

    public void setSubText(boolean visibility, String subText) {
        if (visibility) {
            SubText.setVisibility(View.VISIBLE);
            SubText.setText(subText);
        } else
            SubText.setVisibility(View.GONE);
    }

    public void setItemEnable(boolean enabled) {
        itemClick.setEnabled(enabled);
        ItemText.setEnabled(enabled);
        SubText.setEnabled(enabled);
        ItemCheckedText.setEnabled(enabled);
    }
}
