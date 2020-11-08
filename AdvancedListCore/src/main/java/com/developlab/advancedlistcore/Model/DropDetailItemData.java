package com.developlab.advancedlistcore.Model;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.DropDetailListItemTypeID;

public class DropDetailItemData extends AdvancedBaseDataModel {

    boolean showDetail;

    public DropDetailItemData(int ID, String titleText, String detailText) {
        super(ID, DropDetailListItemTypeID, titleText, detailText);
    }

    public boolean isShowDetail() {
        return showDetail;
    }

    public void setShowDetail(boolean showDetail) {
        this.showDetail = showDetail;
    }

    public void toggleDetail() {
        showDetail = !showDetail;
    }
}
