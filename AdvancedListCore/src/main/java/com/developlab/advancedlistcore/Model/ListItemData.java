package com.developlab.advancedlistcore.Model;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.ListItemTypeID;

public class ListItemData<T> extends AdvancedBaseDataModel {

    private boolean showAttachImage;

    private T data;

    public ListItemData(int ID, String titleText) {
        super(ID, ListItemTypeID, titleText);
        showAttachImage = true;
        setItemEnable(true);
    }

    public ListItemData(int ID, String titleText, String subText) {
        super(ID, ListItemTypeID, titleText, subText);
        showAttachImage = true;
        setItemEnable(true);
    }

    public ListItemData(int ID, String titleText, String subText, boolean showAttachImage) {
        super(ID, ListItemTypeID, titleText, subText);
        this.showAttachImage = showAttachImage;
        setItemEnable(true);
    }

    public ListItemData(int ID, String titleText, String subText, boolean itemEnable, boolean showAttachImage) {
        super(ID, ListItemTypeID, titleText, subText, itemEnable);
        this.showAttachImage = showAttachImage;
    }

    public boolean getShowAttachImage() {
        return showAttachImage;
    }

    public void setShowAttachImage(boolean showAttachImage) {
        this.showAttachImage = showAttachImage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
