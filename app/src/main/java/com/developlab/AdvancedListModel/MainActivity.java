package com.developlab.AdvancedListModel;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.AdvancedListModel.MultItemsActivity.MultipleItemsActivity1;
import com.developlab.AdvancedListModel.SingleItemActivity.ButtonItemActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.CheckBoxItemActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.CheckTextViewItemsActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.DoubleButtonItemsActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.DoubleCheckBoxItemsActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.DropDetailItemActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.DropListItemActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.EditTextItemActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.NormalItemActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.OnlyButtonItemsActivity;
import com.developlab.AdvancedListModel.SingleItemActivity.OnlyTextItemActivity;
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

        //En: Add data;
        //Zh: 添加数据;
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

        demoDataList.add(new SeparateItemData(-2, getString(R.string.Multiple_Item_name)));
        demoDataList.add(new ListItemData<>(12, getString(R.string.Multiple_Item_name) + " 1"));

        demoDataList.add(new SeparateItemData(-5, getString(R.string.Others_name)));
        demoDataList.add(new ListItemData<>(-6, getString(R.string.Switch_Light_Dark_Mode_name)));
        demoDataList.add(new ListItemData<>(-7, getString(R.string.About_name)));

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

                    //En: on click event;
                    //Zh: 点击事件;
                    startActivity(new Intent(MainActivity.this, NormalItemActivity.class));
                }

                if (currentModel.getID() == -6) {
                    onSwitchDarkThemeNormal();
                }

                //En: use switch can easy to use;
                switch (currentModel.getID()) {
                    case -7: startActivity(new Intent(MainActivity.this, AboutActivity.class));break;
                    case 1: startActivity(new Intent(MainActivity.this, SwitchItemActivity.class));break;
                    case 2: startActivity(new Intent(MainActivity.this, CheckBoxItemActivity.class));break;
                    case 3: startActivity(new Intent(MainActivity.this, ButtonItemActivity.class));break;
                    case 4: startActivity(new Intent(MainActivity.this, EditTextItemActivity.class));break;
                    case 5: startActivity(new Intent(MainActivity.this, OnlyButtonItemsActivity.class));break;
                    case 6: startActivity(new Intent(MainActivity.this, DoubleButtonItemsActivity.class));break;
                    case 7: startActivity(new Intent(MainActivity.this, DoubleCheckBoxItemsActivity.class));break;
                    case 8: startActivity(new Intent(MainActivity.this, CheckTextViewItemsActivity.class));break;
                    case 9: startActivity(new Intent(MainActivity.this, DropDetailItemActivity.class));break;
                    case 10: startActivity(new Intent(MainActivity.this, DropListItemActivity.class));break;
                    case 11: startActivity(new Intent(MainActivity.this, OnlyTextItemActivity.class));break;
                    case 12: startActivity(new Intent(MainActivity.this, MultipleItemsActivity1.class));break;
                }
            }
        });

        //En: Set Adapter for RecyclerView;
        demoList.setAdapter(demoListAdapter);

        //En: Refresh the list data set;
        demoListAdapter.notifyDataSetChanged();


    }

    private void onSwitchDarkThemeNormal() {

        //En: Get system is enable Dark Theme;
        int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        boolean isDarkMode =  (mode == Configuration.UI_MODE_NIGHT_YES);

        //En: Switch Dark Theme or Normal Mode;
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
    }


}
