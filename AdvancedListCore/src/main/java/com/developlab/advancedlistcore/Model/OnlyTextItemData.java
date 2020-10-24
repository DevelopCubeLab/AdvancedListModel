package com.developlab.advancedlistcore.Model;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.OnlyTextItemTypeID;

public class OnlyTextItemData extends AdvancedBaseDataModel {

    public OnlyTextItemData(int ID, String text) {
        super(ID, OnlyTextItemTypeID, text);
    }

    public String getText() {
        return super.titleText;
    }

    public void setText(String text) {
        super.titleText = text;
    }
}
