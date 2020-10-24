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
import com.developlab.advancedlistcore.Model.OnlyButtonListItemData;
import com.developlab.advancedlistcore.PublicInterface.AdvanceListModelInterface;
import com.developlab.advancedlistcore.ViewHolder.OnlyButtonListItemViewHolder;

import java.util.ArrayList;

/**
 * En: This component is generally not used alone, please refer to advanced usage;
 * Zh: 这个组件一般不会单独使用请参考高级用法;
 */
public class OnlyButtonItemsActivity extends AppCompatActivity {

    RecyclerView demoList;

    AdvancedListAdapter<OnlyButtonListItemData> advancedListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //En: Set ActionBar text;
        //Zh: 设置ActionBar文字;
        TextView actionBarText = findViewById(R.id.action_bar_title);
        actionBarText.setText(R.string.Only_Button_Item_name);

        demoList = findViewById(R.id.main_recyclerview_id);
        LinearLayoutManager listManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        demoList.setLayoutManager(listManager);

        advancedListAdapter = new AdvancedListAdapter<>();

        ArrayList<OnlyButtonListItemData> listData = new ArrayList<>();
        listData.add(new OnlyButtonListItemData(0, getString(R.string.Button_Text_name)));
        listData.add(new OnlyButtonListItemData(1, false, getString(R.string.Item_Disable_name) + "  " +getString(R.string.Button_Text_name) + "1"));
        listData.add(new OnlyButtonListItemData(2, true, getString(R.string.Button_Text_name) + "2"));

        advancedListAdapter.setList(listData);

        advancedListAdapter.setOnButtonClickListener(new AdvancedListAdapter.OnButtonClickListener<OnlyButtonListItemViewHolder, AdvanceListModelInterface>() {
            @Override
            public void OnButtonClick(View view, OnlyButtonListItemViewHolder holder, int buttonId, int position, AdvanceListModelInterface currentModel) {

                Toast.makeText(OnlyButtonItemsActivity.this, getString(R.string.Click_str) + currentModel.getID(), Toast.LENGTH_SHORT).show();
            }
        });

        demoList.setAdapter(advancedListAdapter);
        advancedListAdapter.notifyDataSetChanged();

    }
}
