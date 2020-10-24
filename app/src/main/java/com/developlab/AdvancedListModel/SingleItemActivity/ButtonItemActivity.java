package com.developlab.AdvancedListModel.SingleItemActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.AdvancedListModel.R;
import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.Model.ButtonListItemData;
import com.developlab.advancedlistcore.PublicInterface.AdvanceListModelInterface;
import com.developlab.advancedlistcore.ViewHolder.ButtonListItemViewHolder;

import java.util.ArrayList;

public class ButtonItemActivity extends AppCompatActivity {

    RecyclerView demoList;

    AdvancedListAdapter<ButtonListItemData> buttonItemsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //En: Set ActionBar text;
        //Zh: 设置ActionBar文字;
        TextView actionBarText = findViewById(R.id.action_bar_title);
        actionBarText.setText(R.string.Button_Item_name);

        demoList = findViewById(R.id.main_recyclerview_id);
        LinearLayoutManager listManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        demoList.setLayoutManager(listManager);

        buttonItemsAdapter = new AdvancedListAdapter<>();

        ArrayList<ButtonListItemData> buttonListData = new ArrayList<>();
        buttonListData.add(new ButtonListItemData(0, getString(R.string.Single_Line_Text_name), getString(R.string.Text_name)));
        buttonListData.add(new ButtonListItemData(1, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name), getString(R.string.Text_name)));
        buttonListData.add(new ButtonListItemData(2, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name), false, getString(R.string.Text_name), false));
//        buttonListData.add(new ButtonListItemData(3, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name), false, getString(R.string.Text_name), true));

        buttonItemsAdapter.setList(buttonListData);
        buttonItemsAdapter.setOnButtonClickListener(new AdvancedListAdapter.OnButtonClickListener<ButtonListItemViewHolder, AdvanceListModelInterface>() {
            @Override
            public void OnButtonClick(View view, ButtonListItemViewHolder holder, int buttonId, int position, AdvanceListModelInterface currentModel) {

            }
        });

        demoList.setAdapter(buttonItemsAdapter);
        buttonItemsAdapter.notifyDataSetChanged();
    }
}
