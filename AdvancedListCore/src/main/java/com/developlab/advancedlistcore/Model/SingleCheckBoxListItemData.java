package com.developlab.advancedlistcore.Model;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.SingleCheckBoxListItemTypeID;

public class SingleCheckBoxListItemData extends AdvancedBaseDataModel {

    private boolean checkBoxShow;  //是否显示CheckBox按钮;
    private boolean buttonStatus;  //CheckBox按钮是否选中;

    public SingleCheckBoxListItemData(int ID, String titleText) {
        super(ID, SingleCheckBoxListItemTypeID, titleText);
        setItemEnable(true);
        checkBoxShow = false;
        buttonStatus = false;
    }

    public SingleCheckBoxListItemData(int ID, String titleText, boolean itemEnable) {
        super(ID, SingleCheckBoxListItemTypeID, titleText);
        setItemEnable(itemEnable);
        checkBoxShow = false;
        buttonStatus = false;
    }

    public SingleCheckBoxListItemData(int ID, String titleText, boolean checkBoxShow, boolean buttonStatus) {
        super(ID, SingleCheckBoxListItemTypeID, titleText);
        setItemEnable(true);
        this.checkBoxShow = checkBoxShow;
        this.buttonStatus = buttonStatus;
    }

    public boolean isCheckBoxShow() {
        return checkBoxShow;
    }

    public void setCheckBoxShow(boolean checkBoxShow) {
        this.checkBoxShow = checkBoxShow;
    }

    public boolean getButtonStatus() {
        return buttonStatus;
    }

    public void setButtonStatus(boolean buttonStatus) {
        this.buttonStatus = buttonStatus;
    }

}
