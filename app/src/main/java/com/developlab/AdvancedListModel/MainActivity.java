package com.developlab.AdvancedListModel;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.Model.ListItemData;
import com.developlab.advancedlistcore.Model.SeparateItemData;
import com.developlab.advancedlistcore.PublicInterface.AdvanceListModelInterface;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //En: Create a RecyclerView;
    //Zh: 创建一个RecyclerView对象;
    RecyclerView demoList;

    //En: Create an AdvancedListAdapter;
    //Zh: 创建AdvancedListAdapter;
    AdvancedListAdapter<AdvanceListModelInterface> demoListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //bind view;
        demoList = findViewById(R.id.main_recyclerview_id);

        //En: Set LinearLayoutManager to RecyclerView;
        //Zh: 给RecyclerView设置LinearLayoutManager;
        LinearLayoutManager listManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        demoList.setLayoutManager(listManager);

        //En: Initialize the Adapter;
        demoListAdapter = new AdvancedListAdapter<>();

        //En: Create an ArrayList to initialize data;
        ArrayList<AdvanceListModelInterface> demoDataList = new ArrayList<>();
        SeparateItemData data0 = new SeparateItemData(-1, getString(R.string.Single_Style_Items_name));
        demoDataList.add(data0);
        ListItemData data1 = new ListItemData(0, getString(R.string.Normal_Item_name));
        demoDataList.add(data1);

        demoDataList.add(new ListItemData<>(1,getString(R.string.Switch_Item_name)));
        demoDataList.add(new ListItemData<>(2,getString(R.string.CheckBox_Item_name)));

        //En: Set up data set for AdvancedListAdapter;
        demoListAdapter.setList(demoDataList);

        //En: Set Adapter for RecyclerView;
        demoList.setAdapter(demoListAdapter);

        //En: Refresh the list data set;
        demoListAdapter.notifyDataSetChanged();


    }


}
