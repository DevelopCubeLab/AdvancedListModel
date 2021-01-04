package com.developlab.AdvancedListModel.MultItemsActivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.AdvancedListModel.R;
import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.Model.ListItemData;
import com.developlab.advancedlistcore.Model.SeparateItemData;
import com.developlab.advancedlistcore.PublicInterface.AdvanceListModelInterface;

import java.util.ArrayList;

public class MultipleItemsActivity1 extends AppCompatActivity {

    RecyclerView demoList;

    AdvancedListAdapter<AdvanceListModelInterface> listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //En: Set ActionBar text;
        //Zh: 设置ActionBar文字;
        TextView actionBarText = findViewById(R.id.action_bar_title);
        actionBarText.setText(R.string.Multiple_Item_name);

        demoList = findViewById(R.id.main_recyclerview_id);
        LinearLayoutManager listManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        demoList.setLayoutManager(listManager);

        listAdapter = new AdvancedListAdapter<>();
        ArrayList<AdvanceListModelInterface> multipleListData = new ArrayList<>();
        multipleListData.add(new SeparateItemData(-1, getString(R.string.Single_Style_Items_name)));
        multipleListData.add(new ListItemData<>(0, getString(R.string.Single_Line_Text_name)));
        listAdapter.setList(multipleListData);
        demoList.setAdapter(listAdapter);
    }
}
