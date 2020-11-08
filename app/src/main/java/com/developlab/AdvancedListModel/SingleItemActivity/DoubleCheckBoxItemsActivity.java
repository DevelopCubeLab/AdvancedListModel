package com.developlab.AdvancedListModel.SingleItemActivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.AdvancedListModel.R;
import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.Model.DoubleCheckBoxListItemData;
import com.developlab.advancedlistcore.Model.SeparateItemData;
import com.developlab.advancedlistcore.PublicInterface.AdvanceListModelInterface;

import java.util.ArrayList;

public class DoubleCheckBoxItemsActivity extends AppCompatActivity {

    RecyclerView demoList;

    /**
     * En: This style we suggest add an attach view;
     */
    AdvancedListAdapter<AdvanceListModelInterface> listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //En: Set ActionBar text;
        //Zh: 设置ActionBar文字;
        TextView actionBarText = findViewById(R.id.action_bar_title);
        actionBarText.setText(R.string.Double_CheckBox_Item_name);

        demoList = findViewById(R.id.main_recyclerview_id);
        LinearLayoutManager listManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        demoList.setLayoutManager(listManager);

        listAdapter = new AdvancedListAdapter<>();

        ArrayList<AdvanceListModelInterface> dataList = new ArrayList<>();
        dataList.add(new SeparateItemData(-1, getString(R.string.Title_Text_name), getString(R.string.Option_1_name), getString(R.string.Option_2_name)));
        dataList.add(new DoubleCheckBoxListItemData(0, getString(R.string.Single_Line_Text_name), getString(R.string.Button_Text_name)));
        dataList.add(new DoubleCheckBoxListItemData(1, getString(R.string.Single_Line_Text_name), true, true, getString(R.string.Button_Text_name)));
        dataList.add(new DoubleCheckBoxListItemData(2, getString(R.string.Single_Line_Text_name), true, false, getString(R.string.Button_Text_name)));
        dataList.add(new DoubleCheckBoxListItemData(3, getString(R.string.Single_Line_Text_name), false, true, getString(R.string.Button_Text_name)));
        dataList.add(new DoubleCheckBoxListItemData(4, getString(R.string.Single_Line_Text_name), false, false, getString(R.string.Button_Text_name)));
        dataList.add(new DoubleCheckBoxListItemData(5, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name), true, true, getString(R.string.Button_Text_name)));
        dataList.add(new DoubleCheckBoxListItemData(6, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name), true, false, getString(R.string.Button_Text_name)));
        dataList.add(new DoubleCheckBoxListItemData(7, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name), false, true, getString(R.string.Button_Text_name)));
        dataList.add(new DoubleCheckBoxListItemData(8, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name), false, false, getString(R.string.Button_Text_name)));
        dataList.add(new DoubleCheckBoxListItemData(9, getString(R.string.Double_Line_Text_name), getString(R.string.Item_Disable_name), true, true, getString(R.string.Button_Text_name), false));
        dataList.add(new DoubleCheckBoxListItemData(10, getString(R.string.Double_Line_Text_name), getString(R.string.Item_Disable_name), true, false, getString(R.string.Button_Text_name), false));
        dataList.add(new DoubleCheckBoxListItemData(11, getString(R.string.Double_Line_Text_name), getString(R.string.Item_Disable_name), false, true, getString(R.string.Button_Text_name), false));
        dataList.add(new DoubleCheckBoxListItemData(12, getString(R.string.Double_Line_Text_name), getString(R.string.Item_Disable_name), false, false, getString(R.string.Button_Text_name), false));

        listAdapter.setList(dataList);

        demoList.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

    }


}
