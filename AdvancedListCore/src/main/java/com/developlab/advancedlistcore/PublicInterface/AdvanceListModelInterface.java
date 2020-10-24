package com.developlab.advancedlistcore.PublicInterface;

import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;

public interface AdvanceListModelInterface {

    /**
     * 获取ID的接口;
     * @return  ID;
     */
    int getID();

    /**
     * 获取视图类型的接口;
     * @return  视图类型;
     */
    @AdvancedListAdapter.ViewType
    int getViewType();


    String getTitleText();

    boolean getEnableSubText();

    String getSubText();

    void setItemEnable(boolean enable);

    boolean getItemEnable();

}
