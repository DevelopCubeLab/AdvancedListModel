package com.developlab.advancedlistcore.Model;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.ButtonListItemTypeID;

public class ButtonListItemData extends AdvancedBaseDataModel {

    private String buttonText;

    private boolean buttonEnable;

    public ButtonListItemData(int ID, String titleText, String buttonText) {
        super(ID, ButtonListItemTypeID, titleText);
        this.buttonText = buttonText;
        this.buttonEnable = true;
    }

    public ButtonListItemData(int ID, String titleText, String subText, String buttonText) {
        super(ID, ButtonListItemTypeID, titleText, subText);
        this.buttonText = buttonText;
        this.buttonEnable = true;
    }

    public ButtonListItemData(int ID, String titleText, String subText, boolean itemEnable, String buttonText, boolean buttonEnable) {
        super(ID, ButtonListItemTypeID, titleText, subText, itemEnable);
        this.buttonText = buttonText;
        this.buttonEnable = buttonEnable;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public boolean getButtonEnable() {
        return buttonEnable;
    }

    public void setButtonEnable(boolean buttonEnable) {
        this.buttonEnable = buttonEnable;
    }
}
