package com.developlab.AdvancedListModel.SingleItemActivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.AdvancedListModel.R;
import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.Model.DropListItemData;

import java.util.ArrayList;

public class DropListItemActivity extends AppCompatActivity {

    RecyclerView demoList;

    AdvancedListAdapter<DropListItemData> listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //En: Set ActionBar text;
        //Zh: 设置ActionBar文字;
        TextView actionBarText = findViewById(R.id.action_bar_title);
        actionBarText.setText(R.string.Drop_List_Item_name);

        demoList = findViewById(R.id.main_recyclerview_id);
        LinearLayoutManager listManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        demoList.setLayoutManager(listManager);

        /**
         * En: IMPORTANT!!;
         *     You must use this method
         *     @see AdvancedListAdapter(Activity activity, Context context);
         *     to initialize the Adapter, otherwise the program will be throw
         *     @see AdvancedListException();
         * Zh:
         */
        listAdapter = new AdvancedListAdapter<>(this, this);

        ArrayList<DropListItemData> dropListItemData = new ArrayList<>();
//        dropListItemData.add(new DropListItemData());


    }
}
