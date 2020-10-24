package com.developlab.AdvancedListModel.SingleItemActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
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
import com.developlab.advancedlistcore.ViewHolder.CheckBoxListItemViewHolder;

import java.util.ArrayList;

import static com.developlab.advancedlistcore.Adapter.AdvancedListAdapter.CheckBoxListItemTypeID;

public class CheckBoxItemActivity extends AppCompatActivity {

    RecyclerView demoList;

    /**
     * En: In fact, the usage of SwitchItem and CheckBoxItem is similar.
     *     @see SwitchItemActivity;
     * Zh: 事实上,SwitchItem和CheckBoxItem使用方法类似;
     *     @see SwitchItemActivity;
     */
    AdvancedListAdapter<TurnViewListItemData> checkBoxItemsAdapter;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //En: Set ActionBar text;
        //Zh: 设置ActionBar文字;
        TextView actionBarText = findViewById(R.id.action_bar_title);
        actionBarText.setText(R.string.CheckBox_Item_name);

        demoList = findViewById(R.id.main_recyclerview_id);
        LinearLayoutManager listManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        demoList.setLayoutManager(listManager);

        checkBoxItemsAdapter = new AdvancedListAdapter<>();

        ArrayList<TurnViewListItemData> turnViewListData = new ArrayList<>();
        //En: default the switch button is turn off;
        turnViewListData.add(new TurnViewListItemData(0, CheckBoxListItemTypeID, getString(R.string.Single_Line_Text_name)));
        TurnViewListItemData singleDisableData = new TurnViewListItemData(1, CheckBoxListItemTypeID, getString(R.string.Single_Line_Text_name) + " " + getString(R.string.Item_Disable_name));
        singleDisableData.setItemEnable(false);
        //En: set switch turn off;
        singleDisableData.setButtonStatus(false);
        //En: add data to list;
        turnViewListData.add(singleDisableData);
        turnViewListData.add(new TurnViewListItemData(2, CheckBoxListItemTypeID, getString(R.string.Single_Line_Text_name), true));
        turnViewListData.add(new TurnViewListItemData(3, CheckBoxListItemTypeID, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name) + " " + getString(R.string.Turn_On_name),true));
        turnViewListData.add(new TurnViewListItemData(4, CheckBoxListItemTypeID, getString(R.string.Double_Line_Text_name), getString(R.string.Additional_Text_name) + " " + getString(R.string.Turn_Off_name),false));
        turnViewListData.add(new TurnViewListItemData(5, CheckBoxListItemTypeID, getString(R.string.Single_Line_Text_name) + " " + getString(R.string.Item_Disable_name), getString(R.string.Additional_Text_name) + " " + getString(R.string.Turn_On_name),false, true));
        turnViewListData.add(new TurnViewListItemData(6, CheckBoxListItemTypeID, getString(R.string.Single_Line_Text_name) + " " + getString(R.string.Item_Disable_name), getString(R.string.Additional_Text_name) + " " + getString(R.string.Turn_Off_name),false, false));

        checkBoxItemsAdapter.setList(turnViewListData);
        checkBoxItemsAdapter.setOnItemClickListener(new AdvancedListAdapter.OnItemClickListener<AdvanceListModelInterface>() {
            @Override
            public void onItemClick(View view, int position, AdvanceListModelInterface currentModel) {

                Toast.makeText(CheckBoxItemActivity.this, getString(R.string.Click_str) + currentModel.getID(), Toast.LENGTH_SHORT).show();
            }
        });

        checkBoxItemsAdapter.setOnCheckedChangeListener(new AdvancedListAdapter.OnCheckedChangeListener<CheckBoxListItemViewHolder, TurnViewListItemData>() {
            //En: This method can monitor the button state change;
            //Zh: 这个方法可以监测到按钮状态改变;

            /**
             *
             * @param position       En: item position;
             *                       Zh: item的位置;
             * @param holder         En: item view holder
             * @see com.developlab.advancedlistcore.ViewHolder.CheckBoxListItemViewHolder;
             *                       Zh: item的view holder;
             * @param currentModel   En: item data;
             *                       Zh: item的数据;
             * @param buttonId       id: R.id.Click_Item_CheckBox_ID  ;
             *                       En: The original Ib of the button, <b>which has no effect under the current module</b>;
             *                       Zh: 按钮的原始ID,<b>在当前模块下没有作用</b>;
             * @param buttonView     En: View of the current switch button
             *                       Zh: 当前开关按钮的视图(View)
             * @param isChecked      En: Is the current CheckBox turned on
             *                           true = turn on ; false = turn off;
             *                       Zh: 当前CheckBox是否已经开启;
             *                           true = 开启 ; false = 关闭;
             */
            @Override
            public void OnCheckedChange(int position, CheckBoxListItemViewHolder holder, TurnViewListItemData currentModel, int buttonId, CompoundButton buttonView, boolean isChecked) {

                Toast.makeText(CheckBoxItemActivity.this, getString(R.string.Button_Status_Change_name) + isChecked, Toast.LENGTH_SHORT).show();
            }
        });
        demoList.setAdapter(checkBoxItemsAdapter);
        checkBoxItemsAdapter.notifyDataSetChanged();
    }
}
