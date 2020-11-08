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
import com.developlab.advancedlistcore.Model.TurnViewListItemData;
import com.developlab.advancedlistcore.PublicInterface.AdvanceListModelInterface;
import com.developlab.advancedlistcore.ViewHolder.CheckedTextViewListItemViewHolder;

import java.util.ArrayList;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.CheckedTextViewListItemTypeID;

public class CheckTextViewItemsActivity extends AppCompatActivity {

    RecyclerView demoList;

    AdvancedListAdapter<TurnViewListItemData> listAdapter;

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

        final ArrayList<TurnViewListItemData> turnViewListData = new ArrayList<>();
        //En: default the switch button is turn off;
        turnViewListData.add(new TurnViewListItemData(0, CheckedTextViewListItemTypeID, getString(R.string.Single_Line_Text_name)));
        TurnViewListItemData singleDisableData = new TurnViewListItemData(1, CheckedTextViewListItemTypeID, getString(R.string.Single_Line_Text_name) + " " + getString(R.string.Item_Disable_name));
        singleDisableData.setItemEnable(false);
        //En: set switch turn off;
        singleDisableData.setButtonStatus(false);
        //En: add data to list;
        turnViewListData.add(singleDisableData);
        turnViewListData.add(new TurnViewListItemData(2, CheckedTextViewListItemTypeID, getString(R.string.Single_Line_Text_name), true));
        turnViewListData.add(new TurnViewListItemData(4, CheckedTextViewListItemTypeID, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name) + " " + getString(R.string.Turn_Off_name),false));
        turnViewListData.add(new TurnViewListItemData(5, CheckedTextViewListItemTypeID, getString(R.string.Single_Line_Text_name) + " " + getString(R.string.Item_Disable_name), getString(R.string.Additional_Text_name) + " " + getString(R.string.Turn_Off_name),false, false));

        listAdapter.setList(turnViewListData);
        listAdapter.setOnItemClickListener(new AdvancedListAdapter.OnItemClickListener<AdvanceListModelInterface>() {
            @Override
            public void onItemClick(View view, int position, AdvanceListModelInterface currentModel) {

                //En: Set other item cancel select;
                //Zh: ;
                for (int i = 0; i < turnViewListData.size(); i++) {
                    if (i != position) {
                        CheckedTextViewListItemViewHolder viewHolder = (CheckedTextViewListItemViewHolder) demoList.findViewHolderForAdapterPosition(i);
                        if (viewHolder != null)
                            viewHolder.setItemClick(false);
                    }
                }
                Toast.makeText(CheckTextViewItemsActivity.this, getString(R.string.Click_str) + currentModel.getID(), Toast.LENGTH_SHORT).show();
            }
        });
        demoList.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }
}
