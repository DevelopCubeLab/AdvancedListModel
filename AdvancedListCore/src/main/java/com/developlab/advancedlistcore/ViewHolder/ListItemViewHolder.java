package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class ListItemViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout itemClick;
    public TextView ItemText;
    private TextView SubText;
    private ImageView AttachImage;

    public ListItemViewHolder(View itemView) {
        super(itemView);
        itemClick = itemView.findViewById(R.id.Click_Item_View_Btn_ID);
        ItemText = itemView.findViewById(R.id.Click_Item_Text_ID);
        SubText = itemView.findViewById(R.id.Click_Item_SubText_ID);
        AttachImage = itemView.findViewById(R.id.Next_Image_ID);
    }

    public void setSubText(boolean visibility, String subText) {
        if (visibility) {
            SubText.setVisibility(View.VISIBLE);
            SubText.setText(subText);
        } else
            SubText.setVisibility(View.GONE);
    }

    public void setAttachImageVisibility(boolean visibility) {
        if (visibility)
            AttachImage.setVisibility(View.VISIBLE);
        else
            AttachImage.setVisibility(View.GONE);
    }
}
