package com.developlab.advancedlistcore.Model;

import androidx.annotation.IntDef;

import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.PublicInterface.AdvanceListModelInterface;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.DropListItemTypeID;

public class DropListItemData implements AdvanceListModelInterface {

    public static final int Vertical_MODE = 0;
    public static final int Horizontal_MODE = 1;

    @IntDef({Vertical_MODE, Horizontal_MODE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayMode {}

    private int ID;

    private String titleText;

    private String subText;

    private boolean itemEnable;

    private AdvancedListAdapter<TurnViewListItemData> listAdapter;  //下拉列表的选择器;

    //选择字段等;
    private int listSelectPosition = -1;  //下拉列表选择的ID 默认-1 未选择;

    @DisplayMode
    private int displayMode;

    public DropListItemData(int ID, String titleText, @DisplayMode int displayMode, String subText, AdvancedListAdapter<TurnViewListItemData> listAdapter) {
        this.ID = ID;
        this.titleText = titleText;
        this.displayMode = displayMode;
        this.subText = subText;
        this.listAdapter = listAdapter;
    }

    public DropListItemData(int ID, String titleText, @DisplayMode int displayMode, String subText, AdvancedListAdapter<TurnViewListItemData> listAdapter, int listSelect) {
        this.ID = ID;
        this.titleText = titleText;
        this.displayMode = displayMode;
        this.subText = subText;
        listSelectPosition = listSelect;
        this.listAdapter = listAdapter;
    }

    public DropListItemData(int ID, String titleText, @DisplayMode int displayMode, String subText, ArrayList<TurnViewListItemData> listItemData) {
        this.ID = ID;
        this.titleText = titleText;
        this.displayMode = displayMode;
        this.subText = subText;
        listAdapter = new AdvancedListAdapter<>();
        listAdapter.setList(listItemData);
    }

    public DropListItemData(int ID, String titleText, @DisplayMode int displayMode, String subText, ArrayList<TurnViewListItemData> listItemData, int listSelect) {
        this.ID = ID;
        this.titleText = titleText;
        this.displayMode = displayMode;
        this.subText = subText;
        listSelectPosition = listSelect;
        listAdapter = new AdvancedListAdapter<>();
        listAdapter.setList(listItemData);
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getViewType() {
        return DropListItemTypeID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
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

    public void setSubText(String subText) {
        this.subText = subText;
    }

    @Override
    public void setItemEnable(boolean enable) {
        itemEnable = enable;
    }

    @Override
    public boolean getItemEnable() {
        return itemEnable;
    }

    public AdvancedListAdapter<TurnViewListItemData> getListAdapter() {
        return listAdapter;
    }

    public int getListSelectPosition() {
        return listSelectPosition;
    }

    public void setListSelectPosition(int listSelectPosition) {
        this.listSelectPosition = listSelectPosition;
    }

    public int getDisplayMode() {
        return displayMode;
    }
}
