package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.Model.DropListItemData;
import com.developlab.advancedlistcore.R;

public class DropListViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout itemClick;
    public TextView ItemText;
    private TextView SubText;
    private TextView HorizontalSubText;

    public DropListViewHolder(@NonNull View itemView) {
        super(itemView);
        itemClick = itemView.findViewById(R.id.Click_Item_DropList_View_Btn_ID);
        ItemText = itemView.findViewById(R.id.Click_Item_DropList_Text_ID);
        SubText = itemView.findViewById(R.id.Click_Item_DropList_SubText_ID);
        HorizontalSubText = itemView.findViewById(R.id.Click_Item_DropList_Horizontal_SubText_ID);
    }

    public void setItemText(String text) {
        ItemText.setText(text);
    }

    public void setSubText(boolean visibility, @DropListItemData.DisplayMode int displayMode, String subText) {
        if (visibility) {
            if (displayMode == DropListItemData.Vertical_MODE) {
                SubText.setText(subText);
                SubText.setVisibility(View.VISIBLE);
                HorizontalSubText.setVisibility(View.GONE);
            } else {
                HorizontalSubText.setText(subText);
                SubText.setVisibility(View.GONE);
                HorizontalSubText.setVisibility(View.VISIBLE);
            }
        } else {
            //隐藏副标题;
            SubText.setVisibility(View.GONE);
            HorizontalSubText.setVisibility(View.GONE);
        }
    }
}
