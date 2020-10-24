package com.developlab.AdvancedListModel.SingleItemActivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.AdvancedListModel.R;
import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.Model.EditTextListItemData;

import java.util.ArrayList;

public class EditTextItemActivity extends AppCompatActivity {

    RecyclerView demoList;

    AdvancedListAdapter<EditTextListItemData> editTextItemsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //En: Set ActionBar text;
        //Zh: 设置ActionBar文字;
        TextView actionBarText = findViewById(R.id.action_bar_title);
        actionBarText.setText(R.string.EditText_Item_name);

        demoList = findViewById(R.id.main_recyclerview_id);
        LinearLayoutManager listManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        demoList.setLayoutManager(listManager);

        editTextItemsAdapter = new AdvancedListAdapter<>();

        ArrayList<EditTextListItemData> listData = new ArrayList<>();

        listData.add(new EditTextListItemData(0, "111", "222"));
        listData.add(new EditTextListItemData(1, "111", "333", "222"));

        editTextItemsAdapter.setList(listData);

        demoList.setAdapter(editTextItemsAdapter);
    }
}
