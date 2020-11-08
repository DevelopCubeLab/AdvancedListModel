package com.developlab.AdvancedListModel.SingleItemActivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.AdvancedListModel.R;
import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.Model.DoubleButtonListItemData;

import java.util.ArrayList;

public class DoubleButtonItemsActivity extends AppCompatActivity {

    RecyclerView demoList;

    AdvancedListAdapter<DoubleButtonListItemData> listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //En: Set ActionBar text;
        //Zh: 设置ActionBar文字;
        TextView actionBarText = findViewById(R.id.action_bar_title);
        actionBarText.setText(R.string.Double_Button_Item_name);

        demoList = findViewById(R.id.main_recyclerview_id);
        LinearLayoutManager listManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        demoList.setLayoutManager(listManager);

        listAdapter = new AdvancedListAdapter<>();

        ArrayList<DoubleButtonListItemData> dataList = new ArrayList<>();
        dataList.add(new DoubleButtonListItemData(0, getString(R.string.Single_Line_Text_name), getString(R.string.Button_Text_name) + "L", getString(R.string.Button_Text_name) + "R"));
        dataList.add(new DoubleButtonListItemData(1, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name), getString(R.string.Button_Text_name) + "L", getString(R.string.Button_Text_name) + "R"));
        dataList.add(new DoubleButtonListItemData(1, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name), getString(R.string.Button_Text_name) + "L", getString(R.string.Button_Text_name) + "R", true, true));
        dataList.add(new DoubleButtonListItemData(1, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name), getString(R.string.Button_Text_name) + "L", getString(R.string.Button_Text_name) + "R", true, false));
        dataList.add(new DoubleButtonListItemData(1, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name), getString(R.string.Button_Text_name) + "L", getString(R.string.Button_Text_name) + "R", false, true));
        dataList.add(new DoubleButtonListItemData(1, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name), getString(R.string.Button_Text_name) + "L", getString(R.string.Button_Text_name) + "R", false, false));

        listAdapter.setList(dataList);

        demoList.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

    }


}
