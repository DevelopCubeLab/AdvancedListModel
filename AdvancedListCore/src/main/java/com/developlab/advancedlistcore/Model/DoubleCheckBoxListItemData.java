package com.developlab.advancedlistcore.Model;

import lombok.Getter;
import lombok.Setter;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.DoubleCheckBoxListItemTypeID;

@Getter
@Setter
public class DoubleCheckBoxListItemData extends AdvancedBaseDataModel {

    private boolean leftCheckBoxChecked;
    private boolean rightCheckBoxChecked;

    private String ButtonText;
    private boolean ButtonEnable;

    public DoubleCheckBoxListItemData(int ID, String titleText, String buttonText) {
        super(ID, DoubleCheckBoxListItemTypeID, titleText);
        ButtonEnable = true;
        setItemEnable(true);
        ButtonText = buttonText;
    }

    public DoubleCheckBoxListItemData(int ID, String titleText, String subText, boolean leftCheckBoxChecked, boolean rightCheckBoxChecked, String buttonText) {
        super(ID, DoubleCheckBoxListItemTypeID, titleText, subText);
        this.leftCheckBoxChecked = leftCheckBoxChecked;
        this.rightCheckBoxChecked = rightCheckBoxChecked;
        ButtonEnable = true;
        setItemEnable(true);
        ButtonText = buttonText;
    }

    public DoubleCheckBoxListItemData(int ID, String titleText, String subText, boolean leftCheckBoxChecked, boolean rightCheckBoxChecked, String buttonText, boolean itemEnable) {
        super(ID, DoubleCheckBoxListItemTypeID, titleText, subText, itemEnable);
        this.leftCheckBoxChecked = leftCheckBoxChecked;
        this.rightCheckBoxChecked = rightCheckBoxChecked;
        ButtonEnable = true;
        ButtonText = buttonText;
    }
}
