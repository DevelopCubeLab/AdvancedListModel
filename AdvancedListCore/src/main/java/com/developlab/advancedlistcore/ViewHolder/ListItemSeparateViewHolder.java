package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class ListItemSeparateViewHolder extends RecyclerView.ViewHolder {

    private TextView TitleText;
    private LinearLayout SeparateAttach;

    private TextView LeftAttachText;
    private TextView RightAttachText;

    public ListItemSeparateViewHolder(View itemView) {
        super(itemView);
        TitleText = itemView.findViewById(R.id.Click_Item_Separate_Text_ID);
        SeparateAttach = itemView.findViewById(R.id.Click_Item_Separate_Attach_ID);
    }

    public void setSeparateAttachVisibility(int visibility) {
        SeparateAttach.setVisibility(visibility);
    }

    public void setTitleText(String titleText) {
        TitleText.setText(titleText);
    }

    public void setLeftAttachText(String text) {
        if (LeftAttachText == null)
            LeftAttachText = itemView.findViewById(R.id.Click_Item_Separate_Attach_Left_Text);
        LeftAttachText.setText(text);
    }

    public void setRightAttachText(String text) {
        if (RightAttachText == null)
            RightAttachText = itemView.findViewById(R.id.Click_Item_Separate_Attach_Right_Text);
        RightAttachText.setText(text);
    }
}
