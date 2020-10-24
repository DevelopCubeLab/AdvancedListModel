package com.developlab.advancedlistcore.Model;

import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.PublicInterface.AdvanceListModelInterface;

public class AdvancedBaseDataModel implements AdvanceListModelInterface {

    protected int ID;

    @AdvancedListAdapter.ViewType
    private int viewType;

    protected String titleText;

    protected String subText;

    boolean ItemEnable;

    public AdvancedBaseDataModel(int ID, @AdvancedListAdapter.ViewType int viewType, String titleText) {
        this.ID = ID;
        this.viewType = viewType;
        this.titleText = titleText;
    }

    public AdvancedBaseDataModel(int ID, @AdvancedListAdapter.ViewType int viewType, String titleText, String subText) {
        this.ID = ID;
        this.viewType = viewType;
        this.titleText = titleText;
        this.subText = subText;
    }

    public AdvancedBaseDataModel(int ID, @AdvancedListAdapter.ViewType int viewType, String titleText, String subText, boolean itemEnable) {
        this.ID = ID;
        this.viewType = viewType;
        this.titleText = titleText;
        this.subText = subText;
        ItemEnable = itemEnable;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getViewType() {
        return viewType;
    }

    @Override
    public String getTitleText() {
        return titleText;
    }

    @Override
    public boolean getEnableSubText() {
        return subText != null;
    }

    @Override
    public String getSubText() {
        return subText;
    }

    @Override
    public void setItemEnable(boolean enable) {
        ItemEnable = enable;
    }

    @Override
    public boolean getItemEnable() {
        return ItemEnable;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }
}
