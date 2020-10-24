package com.developlab.advancedlistcore.Model;

import com.developlab.advancedlistcore.PublicInterface.AdvanceListModelInterface;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.SeparateItemTypeID;

public class SeparateItemData implements AdvanceListModelInterface {

    private int ID;
    private String TitleText;
    private boolean showSeparateAttach;

    private String attachTextLeft;
    private String attachTextRight;

    public SeparateItemData(int ID, String titleText) {
        this.ID = ID;
        TitleText = titleText;
        this.showSeparateAttach = false;
    }

    public SeparateItemData(int ID, String titleText, String attachTextLeft, String attachTextRight) {
        this.ID = ID;
        TitleText = titleText;
        this.showSeparateAttach = true;
        this.attachTextLeft = attachTextLeft;
        this.attachTextRight = attachTextRight;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getViewType() {
        return SeparateItemTypeID;
    }

    @Override
    public String getTitleText() {
        return TitleText;
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

    }

    @Override
    public boolean getItemEnable() {
        return true;
    }

    public boolean getShowSeparateAttach() {
        return showSeparateAttach;
    }

    public void setShowSeparateAttach(boolean showSeparateAttach) {
        this.showSeparateAttach = showSeparateAttach;
    }

    public String getAttachTextLeft() {
        return attachTextLeft;
    }

    public void setAttachTextLeft(String attachTextLeft) {
        this.attachTextLeft = attachTextLeft;
    }

    public String getAttachTextRight() {
        return attachTextRight;
    }

    public void setAttachTextRight(String attachTextRight) {
        this.attachTextRight = attachTextRight;
    }
}
