package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class EditTextListItemViewHolder extends RecyclerView.ViewHolder {

    public TextView ItemText;
    public EditText editText;
    public TextView SubText;

    public EditTextListItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ItemText = itemView.findViewById(R.id.Click_Item_EditText_Text_ID);
        editText = itemView.findViewById(R.id.Click_Item_EditText_ID);
        SubText = itemView.findViewById(R.id.Click_Item_EditText_SubText_ID);
    }

    public void setSubTextVisibility(boolean visibility) {
        if (visibility)
            SubText.setVisibility(View.VISIBLE);
        else
            SubText.setVisibility(View.GONE);
    }

    public void setItemViewEnable(boolean enabled) {
        ItemText.setEnabled(enabled);
        editText.setEnabled(enabled);
        SubText.setEnabled(enabled);
    }

    public void setEditTextInputType(int inputType) {
        editText.setInputType(inputType);
    }
}
