package com.developlab.AdvancedListModel.SingleItemActivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.AdvancedListModel.R;
import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.Model.OnlyTextItemData;

import java.util.ArrayList;

public class OnlyTextActivity extends AppCompatActivity {

    RecyclerView demoList;

    AdvancedListAdapter<OnlyTextItemData> listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //En: Set ActionBar text;
        //Zh: 设置ActionBar文字;
        TextView actionBarText = findViewById(R.id.action_bar_title);
        actionBarText.setText(R.string.Only_Text_Item_name);

        demoList = findViewById(R.id.main_recyclerview_id);
        LinearLayoutManager listManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        demoList.setLayoutManager(listManager);

        listAdapter = new AdvancedListAdapter<>();

        ArrayList<OnlyTextItemData> dataList = new ArrayList<>();
        dataList.add(new OnlyTextItemData(0, getString(R.string.Single_Line_Text_name)));
        dataList.add(new OnlyTextItemData(1, getString(R.string.Double_Line_Text_name)));

        listAdapter.setList(dataList);
        demoList.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

    }


}
