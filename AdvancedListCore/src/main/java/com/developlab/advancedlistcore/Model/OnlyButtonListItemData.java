package com.developlab.advancedlistcore.Model;

import com.developlab.advancedlistcore.PublicInterface.AdvanceListModelInterface;

import lombok.Getter;
import lombok.Setter;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.OnlyButtonListItemTypeID;

@Getter
@Setter
public class OnlyButtonListItemData implements AdvanceListModelInterface {

    private int ID;
    private boolean ItemEnable;
    private String ButtonText;

    public OnlyButtonListItemData(int ID, String buttonText) {
        this.ID = ID;
        ItemEnable = true;
        ButtonText = buttonText;
    }

    public OnlyButtonListItemData(int ID, boolean itemEnable, String buttonText) {
        this.ID = ID;
        ItemEnable = itemEnable;
        ButtonText = buttonText;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getViewType() {
        return OnlyButtonListItemTypeID;
    }

    @Override
    public String getTitleText() {
        return ButtonText;
    }

    @Override
    public boolean getEnableSubText() {
        return false;
    }

    @Override
    public String getSubText() {
        return null;
    }

    @Override
    public void setItemEnable(boolean enable) {
        ItemEnable = enable;
    }

    @Override
    public boolean getItemEnable() {
        return ItemEnable;
    }
}
