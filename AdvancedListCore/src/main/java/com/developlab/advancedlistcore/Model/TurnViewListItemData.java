package com.developlab.advancedlistcore.Model;

import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;

public class TurnViewListItemData extends AdvancedBaseDataModel {

    private boolean buttonStatus; //当前Switch CheckBox是否启用;

    public TurnViewListItemData(int ID, @AdvancedListAdapter.ViewType int viewType, String titleText) {
        super(ID, viewType, titleText);
        this.buttonStatus = false;
        ItemEnable = true;
    }

    public TurnViewListItemData(int ID, @AdvancedListAdapter.ViewType int viewType, String titleText, boolean buttonStatus) {
        super(ID, viewType, titleText);
        this.buttonStatus = buttonStatus;
        ItemEnable = true;
    }

    public TurnViewListItemData(int ID, @AdvancedListAdapter.ViewType int viewType, String titleText, String subText, boolean buttonStatus) {
        super(ID, viewType, titleText, subText);
        this.buttonStatus = buttonStatus;
        ItemEnable = true;
    }

    public TurnViewListItemData(int ID, @AdvancedListAdapter.ViewType int viewType, String titleText, String subText, boolean itemEnable, boolean buttonStatus) {
        super(ID, viewType, titleText, subText, itemEnable);
        this.buttonStatus = buttonStatus;
    }

    public boolean getButtonStatus() {
        return buttonStatus;
    }

    public void setButtonStatus(boolean buttonStatus) {
        this.buttonStatus = buttonStatus;
    }
}
