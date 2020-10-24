package com.developlab.AdvancedListModel.SingleItemActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.AdvancedListModel.R;
import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.Model.ListItemData;
import com.developlab.advancedlistcore.PublicInterface.AdvanceListModelInterface;

import java.util.ArrayList;

public class NormalItemActivity extends AppCompatActivity {

    RecyclerView demoList;

    /**
     * En: if
     *     else
     *
     * Zh: 如果不需要附加数据,直接使用AdvancedListAdapter<ListItemData>即可;
     *     如果需要附加数据,使用AdvancedListAdapter<ListItemData<数据类型>>;
     */
    AdvancedListAdapter<ListItemData> normalItemsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //En: Set ActionBar text;
        //Zh: 设置ActionBar文字;
        TextView actionBarText = findViewById(R.id.action_bar_title);
        actionBarText.setText(R.string.Normal_Item_name);

        demoList = findViewById(R.id.main_recyclerview_id);
        LinearLayoutManager listManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        demoList.setLayoutManager(listManager);

        normalItemsAdapter = new AdvancedListAdapter<>();

        ArrayList<ListItemData> dataList = new ArrayList<>();
        dataList.add(new ListItemData<>(0, getString(R.string.Single_Line_Text_name)));
        dataList.add(new ListItemData<>(1, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name)));
        dataList.add(new ListItemData<>(3, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name) + " " + getString(R.string.Attach_Disable_name), false));
        dataList.add(new ListItemData<>(4, getString(R.string.Double_Line_Text_name), getString(R.string.Item_Disable_name), false, true));
        dataList.add(new ListItemData<>(5, getString(R.string.Double_Line_Text_name), getString(R.string.Item_Disable_name) + " " + getString(R.string.Attach_Disable_name), false, false));

        normalItemsAdapter.setList(dataList);
        normalItemsAdapter.setOnItemClickListener(new AdvancedListAdapter.OnItemClickListener<AdvanceListModelInterface>() {
            @Override
            public void onItemClick(View view, int position, AdvanceListModelInterface currentModel) {

                Toast.makeText(NormalItemActivity.this, getString(R.string.Click_str) + currentModel.getID(), Toast.LENGTH_SHORT).show();
            }
        });
        demoList.setAdapter(normalItemsAdapter);
        normalItemsAdapter.notifyDataSetChanged();

    }
}
