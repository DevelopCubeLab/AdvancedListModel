package com.developlab.AdvancedListModel.SingleItemActivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.AdvancedListModel.R;
import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.Model.DropDetailItemData;

import java.util.ArrayList;

public class DropDetailItemActivity extends AppCompatActivity {

    RecyclerView demoList;

    AdvancedListAdapter<DropDetailItemData> listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //En: Set ActionBar text;
        //Zh: 设置ActionBar文字;
        TextView actionBarText = findViewById(R.id.action_bar_title);
        actionBarText.setText(R.string.Drop_Detail_Item_name);

        demoList = findViewById(R.id.main_recyclerview_id);
        LinearLayoutManager listManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        demoList.setLayoutManager(listManager);

        listAdapter = new AdvancedListAdapter<>();

        ArrayList<DropDetailItemData> dropDetailItemData = new ArrayList<>();
        dropDetailItemData.add(new DropDetailItemData(0,getString(R.string.Demo_Text1), getString(R.string.Demo_Text2)));
        dropDetailItemData.add(new DropDetailItemData(1,getString(R.string.Demo_Text1), getString(R.string.Demo_Text3)));
        dropDetailItemData.add(new DropDetailItemData(2,getString(R.string.Demo_Text1), getString(R.string.Demo_Text2)));
        dropDetailItemData.add(new DropDetailItemData(3,getString(R.string.Demo_Text1), getString(R.string.Demo_Text3)));
        dropDetailItemData.add(new DropDetailItemData(4,getString(R.string.Demo_Text1), getString(R.string.Demo_Text2)));
        dropDetailItemData.add(new DropDetailItemData(5,getString(R.string.Demo_Text1), getString(R.string.Demo_Text3)));
        dropDetailItemData.add(new DropDetailItemData(6,getString(R.string.Demo_Text1), getString(R.string.Demo_Text2)));
        dropDetailItemData.add(new DropDetailItemData(7,getString(R.string.Demo_Text1), getString(R.string.Demo_Text3)));
        dropDetailItemData.add(new DropDetailItemData(8,getString(R.string.Demo_Text1), getString(R.string.Demo_Text2)));
        dropDetailItemData.add(new DropDetailItemData(9,getString(R.string.Demo_Text1), getString(R.string.Demo_Text3)));
        dropDetailItemData.add(new DropDetailItemData(10,getString(R.string.Demo_Text1), getString(R.string.Demo_Text2)));
        dropDetailItemData.add(new DropDetailItemData(11,getString(R.string.Demo_Text1), getString(R.string.Demo_Text3)));
        dropDetailItemData.add(new DropDetailItemData(12,getString(R.string.Demo_Text1), getString(R.string.Demo_Text2)));
        dropDetailItemData.add(new DropDetailItemData(13,getString(R.string.Demo_Text1), getString(R.string.Demo_Text3)));
        dropDetailItemData.add(new DropDetailItemData(14,getString(R.string.Demo_Text1), getString(R.string.Demo_Text2)));
        dropDetailItemData.add(new DropDetailItemData(15,getString(R.string.Demo_Text1), getString(R.string.Demo_Text2)));
        dropDetailItemData.add(new DropDetailItemData(16,getString(R.string.Demo_Text1), getString(R.string.Demo_Text2)));
        dropDetailItemData.add(new DropDetailItemData(17,getString(R.string.Demo_Text1), getString(R.string.Demo_Text2)));
        dropDetailItemData.add(new DropDetailItemData(18,getString(R.string.Demo_Text1), getString(R.string.Demo_Text2)));

        listAdapter.setList(dropDetailItemData);
        demoList.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

    }
}
