package com.developlab.AdvancedListModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.AdvancedListModel.SingleItemActivity.ButtonItemActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.CheckBoxItemActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.EditTextItemActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.NormalItemActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.SwitchItemActivity;
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

        //En: Set ActionBar text;
        //Zh: 设置ActionBar文字;
        TextView actionBarText = findViewById(R.id.action_bar_title);
        actionBarText.setText(R.string.app_name);

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

        //En: ;
        //Zh: ;
        demoDataList.add(new ListItemData<>(1,getString(R.string.Switch_Item_name)));
        demoDataList.add(new ListItemData<>(2,getString(R.string.CheckBox_Item_name)));
        demoDataList.add(new ListItemData<>(3,getString(R.string.Button_Item_name)));
        demoDataList.add(new ListItemData<>(4,getString(R.string.EditText_Item_name)));
        demoDataList.add(new ListItemData<>(5,getString(R.string.Only_Button_Item_name)));
        demoDataList.add(new ListItemData<>(6,getString(R.string.Double_Button_Item_name)));
        demoDataList.add(new ListItemData<>(7,getString(R.string.Double_CheckBox_Item_name)));
        demoDataList.add(new ListItemData<>(8,getString(R.string.CheckedTextView_Item_name)));
        demoDataList.add(new ListItemData<>(9,getString(R.string.Drop_Detail_Item_name)));
        demoDataList.add(new ListItemData<>(10,getString(R.string.Drop_List_Item_name)));
        demoDataList.add(new ListItemData<>(11,getString(R.string.Only_Text_Item_name)));

        //En: Set up data set for AdvancedListAdapter;
        demoListAdapter.setList(demoDataList);

        //En: ;
        //Zh: 为items设置点击事件的监听;
        demoListAdapter.setOnItemClickListener(new AdvancedListAdapter.OnItemClickListener<AdvanceListModelInterface>() {
            //En: ;
            //Zh: 当Item被点击时的回调方法;
            @Override
            public void onItemClick(View view, int position, AdvanceListModelInterface currentModel) {

                //En: ;
                //Zh: 通过获取ID来判断item被点击情况;
                if (currentModel.getID() == 0) {

                    //En: on click;
                    //Zh: 点击事件;
                    startActivity(new Intent(MainActivity.this, NormalItemActivity.class));
                }

                switch (currentModel.getID()) {
                    case 1: startActivity(new Intent(MainActivity.this, SwitchItemActivity.class));break;
                    case 2: startActivity(new Intent(MainActivity.this, CheckBoxItemActivity.class));break;
                    case 3: startActivity(new Intent(MainActivity.this, ButtonItemActivity.class));break;
                    case 4: startActivity(new Intent(MainActivity.this, EditTextItemActivity.class));break;
//                    case 3: startActivity(new Intent(MainActivity.this, ));break;
//                    case 4: startActivity(new Intent(MainActivity.this, ));break;
//                    case 5: startActivity(new Intent(MainActivity.this, ));break;
//                    case 6: startActivity(new Intent(MainActivity.this, ));break;
                }
            }
        });

        //En: Set Adapter for RecyclerView;
        demoList.setAdapter(demoListAdapter);

        //En: Refresh the list data set;
        demoListAdapter.notifyDataSetChanged();


    }


}
