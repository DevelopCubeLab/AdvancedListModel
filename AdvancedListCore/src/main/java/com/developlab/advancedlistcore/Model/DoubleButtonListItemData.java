package com.developlab.advancedlistcore.Model;

import lombok.Getter;
import lombok.Setter;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.DoubleButtonListItemTypeID;

@Getter
@Setter
public class DoubleButtonListItemData extends AdvancedBaseDataModel {

    private String leftButtonText;
    private String rightButtonText;

    private boolean leftButtonEnable;
    private boolean rightButtonEnable;

    public DoubleButtonListItemData(int ID, String titleText, String leftButtonText, String rightButtonText) {
        super(ID, DoubleButtonListItemTypeID, titleText);
        this.leftButtonText = leftButtonText;
        this.rightButtonText = rightButtonText;
        this.leftButtonEnable = true;
        this.rightButtonEnable = true;
    }

    public DoubleButtonListItemData(int ID, String titleText, String subText, String leftButtonText, String rightButtonText) {
        super(ID, DoubleButtonListItemTypeID, titleText, subText);
        this.leftButtonText = leftButtonText;
        this.rightButtonText = rightButtonText;
        this.leftButtonEnable = true;
        this.rightButtonEnable = true;
    }

    public DoubleButtonListItemData(int ID, String titleText, String subText, String leftButtonText, String rightButtonText, boolean leftButtonEnable, boolean rightButtonEnable) {
        super(ID, DoubleButtonListItemTypeID, titleText, subText);
        this.leftButtonText = leftButtonText;
        this.rightButtonText = rightButtonText;
        this.leftButtonEnable = leftButtonEnable;
        this.rightButtonEnable = rightButtonEnable;
    }
}
