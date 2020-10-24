package com.developlab.advancedlistcore.Model;

import lombok.Getter;
import lombok.Setter;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.EditTextListItemTypeID;

@Getter
@Setter
public class EditTextListItemData extends AdvancedBaseDataModel {

    private String EditTextHint;
    private String EditText;
    private int EditTextInputType;

    private String EditTextInputText;

    public EditTextListItemData(int ID, String titleText, String editTextHint) {
        super(ID, EditTextListItemTypeID, titleText);
        EditTextHint = editTextHint;
        setItemEnable(true);
    }

    public EditTextListItemData(int ID, String titleText, String subText, String editTextHint) {
        super(ID, EditTextListItemTypeID, titleText, subText);
        EditTextHint = editTextHint;
        setItemEnable(true);
    }
}
