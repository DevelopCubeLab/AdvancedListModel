package com.developlab.advancedlistcore.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.Model.AdvancedBaseDataModel;
import com.developlab.advancedlistcore.Model.ButtonListItemData;
import com.developlab.advancedlistcore.Model.DoubleButtonListItemData;
import com.developlab.advancedlistcore.Model.DoubleCheckBoxListItemData;
import com.developlab.advancedlistcore.Model.DropDetailItemData;
import com.developlab.advancedlistcore.Model.DropListItemData;
import com.developlab.advancedlistcore.Model.EditTextListItemData;
import com.developlab.advancedlistcore.Model.ListItemData;
import com.developlab.advancedlistcore.Model.OnlyButtonListItemData;
import com.developlab.advancedlistcore.Model.OnlyTextItemData;
import com.developlab.advancedlistcore.Model.SeparateItemData;
import com.developlab.advancedlistcore.Model.SingleCheckBoxListItemData;
import com.developlab.advancedlistcore.Model.TurnViewListItemData;
import com.developlab.advancedlistcore.PublicInterface.AdvanceListModelInterface;
import com.developlab.advancedlistcore.PublicInterface.AdvancedListException;
import com.developlab.advancedlistcore.PublicInterface.MenuPopupWindow;
import com.developlab.advancedlistcore.R;
import com.developlab.advancedlistcore.ViewHolder.ButtonListItemViewHolder;
import com.developlab.advancedlistcore.ViewHolder.CheckBoxListItemViewHolder;
import com.developlab.advancedlistcore.ViewHolder.CheckedTextViewListItemViewHolder;
import com.developlab.advancedlistcore.ViewHolder.DoubleButtonListItemViewHolder;
import com.developlab.advancedlistcore.ViewHolder.DoubleCheckBoxListItemViewHolder;
import com.developlab.advancedlistcore.ViewHolder.DropDetailViewHolder;
import com.developlab.advancedlistcore.ViewHolder.DropListViewHolder;
import com.developlab.advancedlistcore.ViewHolder.EditTextListItemViewHolder;
import com.developlab.advancedlistcore.ViewHolder.ListItemSeparateViewHolder;
import com.developlab.advancedlistcore.ViewHolder.ListItemViewHolder;
import com.developlab.advancedlistcore.ViewHolder.OnlyButtonListItemViewHolder;
import com.developlab.advancedlistcore.ViewHolder.OnlyTextViewHolder;
import com.developlab.advancedlistcore.ViewHolder.SingleCheckBoxViewHolder;
import com.developlab.advancedlistcore.ViewHolder.SwitchListItemViewHolder;

// implementation 'org.jetbrains:annotations-java5:15.0'
//import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class AdvancedListAdapter<T extends AdvanceListModelInterface> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int SeparateItemTypeID = 0;
    public static final int ListItemTypeID = 1;
    public static final int SwitchListItemTypeID = 2;
    public static final int CheckBoxListItemTypeID = 3;
    public static final int ButtonListItemTypeID = 4;
    public static final int EditTextListItemTypeID = 5;
    public static final int SingleCheckBoxListItemTypeID = 6;
    public static final int DoubleButtonListItemTypeID = 7;
    public static final int DoubleCheckBoxListItemTypeID = 8;
    public static final int OnlyButtonListItemTypeID = 9;
    public static final int CheckedTextViewListItemTypeID = 10;
    public static final int DropDetailListItemTypeID = 11;
    public static final int DropListItemTypeID = 12;
    public static final int OnlyTextItemTypeID = 14;

    @IntDef({SeparateItemTypeID,
            ListItemTypeID,
            SwitchListItemTypeID,
            CheckBoxListItemTypeID,
            ButtonListItemTypeID,
            EditTextListItemTypeID,
            SingleCheckBoxListItemTypeID,
            DoubleButtonListItemTypeID,
            DoubleCheckBoxListItemTypeID,
            OnlyButtonListItemTypeID,
            CheckedTextViewListItemTypeID,
            DropDetailListItemTypeID,
            DropListItemTypeID,
            OnlyTextItemTypeID})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewType {}

    //数据对象序列;
    private ArrayList<T> AdvancedListData = new ArrayList<>();

    private Activity activity;
    private Context context;

    //监听器对象;
    private OnItemClickListener<AdvanceListModelInterface> onItemClickListener;
    private OnCheckedChangeListener<RecyclerView.ViewHolder, AdvanceListModelInterface> onCheckedChangeListener;
    private OnButtonClickListener<RecyclerView.ViewHolder, AdvanceListModelInterface> onButtonClickListener;

    public AdvancedListAdapter() {
    }

    public AdvancedListAdapter(Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
    }

    /**
     * 返回选择不同类型的列表
     * @param position  位置信息;
     * @return 0 分割线
     *         1 普通列表
     *         2 带选择开关的列表
     *         3 带复选框的列表
     *         4 带按钮的列表
     *         5 带EditText的列表
     *         6 单行带CheckBox的列表
     *         7 横向双按钮的列表
     *         8 横向双CheckBox和单按钮的列表;
     *         9 单独按钮的列表;
     *         10 CheckedTextView的列表;
     *         11 点击可以显示详情的列表;
     */
    @Override
    public int getItemViewType(int position) {
        if (AdvancedListData != null) {
            return AdvancedListData.get(position).getViewType();
        }
        return super.getItemViewType(position);
    }

    /**
     * 构造列表视图界面的方法;
     * @param parent     视图;
     * @param viewType   item类型;
     * @return           返回构造的视图(ViewHolder);
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, @ViewType int viewType) {

        LayoutInflater itemInflater = LayoutInflater.from(parent.getContext());
        View normalItemView = itemInflater.inflate(R.layout.click_list_item_view,parent,false);
        ListItemViewHolder normalViewHolder = new ListItemViewHolder(normalItemView);

        if (viewType == SeparateItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_separate_item_view,parent,false);
            return new ListItemSeparateViewHolder(itemView);
        }

        if (viewType == ListItemTypeID) {
            return normalViewHolder;
        }

        if (viewType == SwitchListItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_switch_item_view,parent,false);
            return new SwitchListItemViewHolder(itemView);
        }

        if (viewType == CheckBoxListItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_checkbox_item_view,parent,false);
            return new CheckBoxListItemViewHolder(itemView);
        }

        if (viewType == ButtonListItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_button_item_view,parent,false);
            return new ButtonListItemViewHolder(itemView);
        }

        if (viewType == EditTextListItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_edittext_item_view,parent, false);
            EditTextListItemViewHolder viewHolder = new EditTextListItemViewHolder(itemView);
            viewHolder.setIsRecyclable(false);  //设置item禁止回收;
            return viewHolder;
        }

        if (viewType == SingleCheckBoxListItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_single_item_view,parent,false);
            return new SingleCheckBoxViewHolder(itemView);
        }

        if (viewType == DoubleButtonListItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_double_button_item_view,parent,false);
            return new DoubleButtonListItemViewHolder(itemView);
        }

        if (viewType == DoubleCheckBoxListItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_double_checkbox_item_view,parent,false);
            return new DoubleCheckBoxListItemViewHolder(itemView);
        }

        if (viewType == OnlyButtonListItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_only_button_view,parent,false);
            return new OnlyButtonListItemViewHolder(itemView);
        }

        if (viewType == CheckedTextViewListItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_checktextview_item_view,parent,false);
            return new CheckedTextViewListItemViewHolder(itemView);
        }

        if (viewType == DropDetailListItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_drop_detail_view,parent,false);
            return new DropDetailViewHolder(itemView);
        }

        if (viewType == DropListItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_drop_list_view,parent,false);
            return new DropListViewHolder(itemView);
        }

        if (viewType == OnlyTextItemTypeID) {
            View itemView = itemInflater.inflate(R.layout.click_list_only_text_item_view,parent,false);
            return new OnlyTextViewHolder(itemView);
        }

        return normalViewHolder;
    }

    /**
     * 通过不同的视图类型设置相应的方法;
     * @param holder      ViewHolder对象;
     * @param position    位置信息;
     */
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        int viewType = AdvancedListData.get(position).getViewType();

        //处理分隔线的方法;
        if (viewType == SeparateItemTypeID) {

            SeparateItemData CurrentModel = (SeparateItemData) AdvancedListData.get(position);
            ListItemSeparateViewHolder viewHolder = (ListItemSeparateViewHolder) holder;
            viewHolder.setTitleText(CurrentModel.getTitleText());

            //显示附加组件;
            if (CurrentModel.getShowSeparateAttach()) {
                viewHolder.setSeparateAttachVisibility(View.VISIBLE);
                if (CurrentModel.getAttachTextLeft() != null) {
                    viewHolder.setLeftAttachText(CurrentModel.getAttachTextLeft());
                }
                if (CurrentModel.getAttachTextRight() != null) {
                    viewHolder.setRightAttachText(CurrentModel.getAttachTextRight());
                }
            } else {
                viewHolder.setSeparateAttachVisibility(View.GONE);
            }
        }

        if (viewType == ListItemTypeID) {

            ListItemData<?> CurrentModel = (ListItemData<?>) AdvancedListData.get(position);

            final ListItemViewHolder viewHolder = (ListItemViewHolder) holder;

            viewHolder.ItemText.setText(CurrentModel.getTitleText());

            viewHolder.setItemViewEnable(CurrentModel.getItemEnable());

            //判断是否双行文字显示;
            viewHolder.setSubText(CurrentModel.getEnableSubText(),CurrentModel.getSubText());

            //设置是否显示右侧 > ;
            viewHolder.setAttachImageVisibility(CurrentModel.getShowAttachImage());

            //给界面设置点击事件;
            if (onItemClickListener != null) {
                viewHolder.itemClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v,position,CurrentModel);
                    }
                });
            }

        }

        if (viewType == SwitchListItemTypeID) {

            TurnViewListItemData CurrentModel = (TurnViewListItemData) AdvancedListData.get(position);
            final SwitchListItemViewHolder viewHolder = (SwitchListItemViewHolder) holder;

            viewHolder.ItemText.setText(CurrentModel.getTitleText());

            //设置Switch按钮状态;
            viewHolder.setSwitchButtonChecked(CurrentModel.getButtonStatus());

            //设置Item是否可操作(Enable);
            viewHolder.setItemViewEnable(CurrentModel.getItemEnable());

            //判断是否双行文字显示;
            viewHolder.setSubText(CurrentModel.getEnableSubText(),CurrentModel.getSubText());

            //给界面设置点击事件;
            viewHolder.ClickItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    viewHolder.setSwitchButtonChecked(!viewHolder.SwitchButton.isChecked());

                    if (onItemClickListener != null)
                        onItemClickListener.onItemClick(v,position,CurrentModel);
                }
            });

            //设置Switch按钮监听器;
            if (onCheckedChangeListener != null) {
                viewHolder.SwitchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        //处理因为点击取消使用setChecked方法导致重复监听的问题;
                        if (!viewHolder.SwitchButton.isPressed() && !viewHolder.ClickItemView.isPressed())
                            return;

                        onCheckedChangeListener.OnCheckedChange(position,viewHolder,CurrentModel,R.id.Click_Item_Switch_Button_ID,buttonView,isChecked);
                    }
                });
            }

        }

        if (viewType == CheckBoxListItemTypeID) {
            TurnViewListItemData CurrentModel = (TurnViewListItemData) AdvancedListData.get(position);
            final CheckBoxListItemViewHolder viewHolder = (CheckBoxListItemViewHolder) holder;

            viewHolder.ItemText.setText(CurrentModel.getTitleText());

            //判断是否双行文字显示;
            viewHolder.setSubText(CurrentModel.getEnableSubText(),CurrentModel.getSubText());

            viewHolder.setCheckBoxChecked(CurrentModel.getButtonStatus());

            //设置Item Enable;
            viewHolder.setItemEnable(CurrentModel.getItemEnable());

            if (onItemClickListener != null) {
                viewHolder.itemClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        viewHolder.CheckBox.setChecked(!viewHolder.CheckBox.isChecked());

                        onItemClickListener.onItemClick(v,position,CurrentModel);
                    }
                });
            }

            if (onCheckedChangeListener != null) {
                viewHolder.CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        //处理因为点击取消使用setChecked方法导致重复监听的问题;
//                        if (!viewHolder.CheckBox.isPressed() && !viewHolder.CheckBox.isPressed())
//                            return;

                        onCheckedChangeListener.OnCheckedChange(position, viewHolder, CurrentModel,R.id.Click_Item_CheckBox_ID,buttonView, isChecked);

                    }
                });
            }

        }

        //带按钮的item处理视图方法;
        if (viewType == ButtonListItemTypeID) {

            ButtonListItemData CurrentModel = (ButtonListItemData) AdvancedListData.get(position);
            final ButtonListItemViewHolder viewHolder = (ButtonListItemViewHolder) holder;

            viewHolder.ItemText.setText(CurrentModel.getTitleText());

            //设置按钮的文字;
            if (!TextUtils.isEmpty(CurrentModel.getButtonText()))
                viewHolder.setItemButtonText(CurrentModel.getButtonText());

            //判断是否双行文字显示;
            viewHolder.setSubText(CurrentModel.getEnableSubText(),CurrentModel.getSubText());

            //设置按钮是否可点击;
            viewHolder.setItemButtonEnable(CurrentModel.getButtonEnable());

            //给界面设置点击事件;
            if (onItemClickListener != null) {
                viewHolder.itemClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        onItemClickListener.onItemClick(v,position,CurrentModel);
                    }
                });
            }

            if (onButtonClickListener != null) {
                viewHolder.ItemButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        onButtonClickListener.OnButtonClick(v,viewHolder,R.id.Click_Item_Button_ID,position,CurrentModel);
                    }
                });
            }

        }

        if (viewType == EditTextListItemTypeID) {
            EditTextListItemData CurrentModel = (EditTextListItemData) AdvancedListData.get(position);
            EditTextListItemViewHolder viewHolder = (EditTextListItemViewHolder) holder;

            //设置标题;
            viewHolder.ItemText.setText(CurrentModel.getTitleText());

            //设置文本框提示文字;
            viewHolder.editText.setHint(CurrentModel.getEditTextHint());

            //设置item是否启用;
            viewHolder.setItemViewEnable(CurrentModel.getItemEnable());

            viewHolder.editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    CurrentModel.setEditTextInputText(s.toString());
                    AdvancedListData.set(position, (T) CurrentModel);
                }
            });

        }

        if (viewType == SingleCheckBoxListItemTypeID) {

            SingleCheckBoxListItemData CurrentModel = (SingleCheckBoxListItemData) AdvancedListData.get(position);
            final SingleCheckBoxViewHolder viewHolder = (SingleCheckBoxViewHolder) holder;

            //设置标题文字;
            viewHolder.ItemText.setText(CurrentModel.getTitleText());

            //显示CheckBox;
            viewHolder.setItemCheckBoxVisibility(CurrentModel.isCheckBoxShow());

            //设置CheckBox选中状态;
            viewHolder.ItemCheckBox.setChecked(CurrentModel.getButtonStatus());

            //设置item Enable;
            viewHolder.setItemViewEnable(CurrentModel.getItemEnable());

            //给界面设置点击事件;
            if (onItemClickListener != null) {
                viewHolder.itemClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (CurrentModel.getButtonStatus()) {
                            viewHolder.ItemCheckBox.setChecked(!viewHolder.ItemCheckBox.isChecked());
                        }

                        onItemClickListener.onItemClick(v,position,CurrentModel);
                    }
                });
            }

        }

        if (viewType == DoubleButtonListItemTypeID) {

            DoubleButtonListItemData CurrentModel = (DoubleButtonListItemData) AdvancedListData.get(position);

            DoubleButtonListItemViewHolder viewHolder = (DoubleButtonListItemViewHolder) holder;

            //设置标题文字;
            viewHolder.ItemText.setText(CurrentModel.getTitleText());
            viewHolder.SubText.setText(CurrentModel.getSubText());

            //设置两个按钮的文字;
            viewHolder.leftItemButton.setText(CurrentModel.getLeftButtonText());
            viewHolder.rightItemButton.setText(CurrentModel.getRightButtonText());

            //设置两个按钮的状态;
            viewHolder.leftItemButton.setEnabled(CurrentModel.isLeftButtonEnable());
            viewHolder.rightItemButton.setEnabled(CurrentModel.isRightButtonEnable());

            //设置item点击事件;
            if (onItemClickListener != null) {
                viewHolder.itemClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v,position,CurrentModel);
                    }
                });
            }

            //为两个按钮设置监听器;
            if (onButtonClickListener != null) {
                viewHolder.leftItemButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClickListener.OnButtonClick(v, viewHolder, R.id.Click_Item_Double_Left_Button_ID,position,CurrentModel);
                    }
                });
                viewHolder.rightItemButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClickListener.OnButtonClick(v, viewHolder, R.id.Click_Item_Double_Right_Button_ID,position,CurrentModel);
                    }
                });
            }
        }

        if (viewType == DoubleCheckBoxListItemTypeID) {

            DoubleCheckBoxListItemData CurrentModel = (DoubleCheckBoxListItemData) AdvancedListData.get(position);
            final DoubleCheckBoxListItemViewHolder viewHolder = (DoubleCheckBoxListItemViewHolder) holder;

            //设置标题文字;
            viewHolder.ItemText.setText(CurrentModel.getTitleText());

            //判断是否双行文字显示;
            viewHolder.setSubText(CurrentModel.getEnableSubText(),CurrentModel.getSubText());

            //设置两个CheckBox选中状态;
            viewHolder.leftItemCheckBox.setChecked(CurrentModel.isLeftCheckBoxChecked());
            viewHolder.rightItemCheckBox.setChecked(CurrentModel.isRightCheckBoxChecked());

            viewHolder.ItemButton.setText(CurrentModel.getButtonText());

            //控制是否可点击;
            viewHolder.setItemViewEnable(CurrentModel.getItemEnable());

            //设置item点击事件;
            if (onItemClickListener != null) {
                viewHolder.itemClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v,position,CurrentModel);
                    }
                });
            }

            if (onCheckedChangeListener != null) {
                viewHolder.leftItemCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        //当点击时触发数据改变 解决setItemEnable发生错误回调;
                        if (viewHolder.leftItemCheckBox.isPressed()) {
                            CurrentModel.setLeftCheckBoxChecked(isChecked);
                            AdvancedListData.set(position, (T) CurrentModel);

                            onCheckedChangeListener.OnCheckedChange(position,viewHolder,CurrentModel,R.id.Click_Item_Double_Left_CheckBox_ID,buttonView,isChecked);
                        }
                    }
                });
                viewHolder.rightItemCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        //当点击时触发数据改变 解决setItemEnable发生错误回调;
                        if (viewHolder.rightItemCheckBox.isPressed()) {
                            CurrentModel.setRightCheckBoxChecked(isChecked);
                            AdvancedListData.set(position, (T) CurrentModel);

                            onCheckedChangeListener.OnCheckedChange(position,viewHolder,CurrentModel,R.id.Click_Item_Double_Right_CheckBox_ID,buttonView,isChecked);
                        }
                    }
                });
            }

            if (onButtonClickListener != null) {
                viewHolder.ItemButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClickListener.OnButtonClick(v,viewHolder,R.id.Click_Item_Double_Button_ID,position,CurrentModel);
                    }
                });
            }

        }

        if (viewType == OnlyButtonListItemTypeID) {

            OnlyButtonListItemData CurrentModel = (OnlyButtonListItemData) AdvancedListData.get(position);
            final OnlyButtonListItemViewHolder viewHolder = (OnlyButtonListItemViewHolder) holder;

            //给按钮设置文字;
            viewHolder.ItemButton.setText(CurrentModel.getTitleText());

            //设置按钮是否启用;
            viewHolder.setItemButtonEnable(CurrentModel.getItemEnable());

            viewHolder.ItemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (onButtonClickListener != null)
                        onButtonClickListener.OnButtonClick(v,viewHolder,R.id.Click_Item_Only_Button_ID,position,CurrentModel);
                }
            });
        }

        if (viewType == CheckedTextViewListItemTypeID) {

            TurnViewListItemData CurrentModel = (TurnViewListItemData) AdvancedListData.get(position);
            final CheckedTextViewListItemViewHolder viewHolder = (CheckedTextViewListItemViewHolder) holder;

            viewHolder.ItemText.setText(CurrentModel.getTitleText());

            //判断是否双行文字显示;
            viewHolder.setSubText(CurrentModel.getEnableSubText(),CurrentModel.getSubText());

            //判断item是否被选中;
            viewHolder.setItemClick(CurrentModel.getButtonStatus());

            //判断item是否启用;
            viewHolder.setItemEnable(CurrentModel.getItemEnable());

            viewHolder.itemClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    viewHolder.setItemClick(true);

                    if (onItemClickListener != null)
                        onItemClickListener.onItemClick(v,position,CurrentModel);
                }
            });
        }

        if (viewType == DropDetailListItemTypeID) {

            DropDetailItemData CurrentModel = (DropDetailItemData) AdvancedListData.get(position);
            final DropDetailViewHolder viewHolder = (DropDetailViewHolder) holder;

            viewHolder.ItemText.setText(CurrentModel.getTitleText());
            viewHolder.DetailText.setText(CurrentModel.getSubText());

            viewHolder.setDropView(CurrentModel.isShowDetail());

            viewHolder.itemClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //切换显示状态;
                    viewHolder.switchDropView();
                    //标记数据状态;
                    CurrentModel.toggleDetail();
                    AdvancedListData.set(position, (T) CurrentModel);
                }
            });
        }

        if (viewType == DropListItemTypeID) {

            DropListItemData CurrentModel = (DropListItemData) AdvancedListData.get(position);
            DropListViewHolder viewHolder = (DropListViewHolder) holder;

            //设置标题文字;
            viewHolder.setItemText(CurrentModel.getTitleText());

            //判断是否双行文字显示;
            viewHolder.setSubText(CurrentModel.getEnableSubText(), CurrentModel.getDisplayMode(),CurrentModel.getSubText());

            if (CurrentModel.getListAdapter() != null && activity != null) {
                viewHolder.itemClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //获取Adapter;
                        AdvancedListAdapter<TurnViewListItemData> listAdapter = CurrentModel.getListAdapter();
                        //设置下拉选择;
                        if (CurrentModel.getListSelectPosition() > -1) {
                            //获取数据;
                            ArrayList<TurnViewListItemData> listData = listAdapter.getAdvancedListData();
                            if (listData != null && listData.size() > 0) {
                                for (int i = 0; i < listData.size(); i++) {
                                    TurnViewListItemData data = listData.get(i);
                                    //设置是否选择;
                                    data.setButtonStatus(CurrentModel.getListSelectPosition() == i);
                                    listData.set(i, data);
                                }
                            }
                        }
                        //设置PopupWindow;
                        final MenuPopupWindow SelectWindow = new MenuPopupWindow(context,activity);
                        SelectWindow.setFocusable(true);
                        SelectWindow.setOutsideTouchable(true);

                        //设置监听器;
                        listAdapter.setOnItemClickListener(new OnItemClickListener<AdvanceListModelInterface>() {
                            @Override
                            public void onItemClick(View view, int itemPosition, AdvanceListModelInterface currentModel) {
                                //设置选择的item文字;
                                viewHolder.setSubText(true, CurrentModel.getDisplayMode(), currentModel.getTitleText());
                                //保存选择的item的position;
                                CurrentModel.setListSelectPosition(itemPosition);
                                CurrentModel.setSubText(currentModel.getTitleText());
                                AdvancedListData.set(position, (T) CurrentModel);
                                //关闭Popup Window;
                                SelectWindow.dismiss();

                                if (onItemClickListener != null) {
                                    onItemClickListener.onItemClick(view,itemPosition,currentModel);
                                }
                            }
                        });
                        //设置Adapter;
                        SelectWindow.setMenuListAdapter(listAdapter);
                        SelectWindow.setSizeAndShowAsDropDown(viewHolder.ItemText,265, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.START,15,0);


                    }
                });
            } else {
                //抛出异常;
                if (activity == null) /** @see AdvancedListAdapter(Activity activity, Context context) */
                    throw new AdvancedListException("The parameter 'activity' is missing, " +
                            "please use the'public AdvancedListAdapter(Activity activity, Context context)' " +
                            "method to construct AdvancedListAdapter");
                else
                    throw new AdvancedListException("No data in ListAdapter, unable to construct list!");
            }

        }

        if (viewType == OnlyTextItemTypeID) {
            OnlyTextItemData CurrentModel = (OnlyTextItemData) AdvancedListData.get(position);
            OnlyTextViewHolder viewHolder = (OnlyTextViewHolder) holder;
            viewHolder.setText(CurrentModel.getText());

        }

    }

    /**
     * 获取列表总长度;
     * @return  列表长度;
     */
    @Override
    public int getItemCount() {
        if (AdvancedListData != null)
            return AdvancedListData.size();
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return AdvancedListData.get(position).getID();
    }

    /**
     * 设置列表;
     * @param getList  设置列表;
     */
    public void setList(ArrayList<T> getList) {

        if (getList != null) {
            AdvancedListData.clear();
            AdvancedListData.addAll(getList);
        }
    }

    /**
     * 获取列表数据;
     * @return  列表数据;
     */
    public ArrayList<T> getAdvancedListData() {
        return AdvancedListData;
    }

    /**
     * 在已有列表中追加数据;
     * 如果想覆盖列表，请查看 @see public void setList(ArrayList<T> getList)
     * @param addList  追加的列表数据;
     */
    public void addDataList(ArrayList<T> addList) {
        if (addList != null)
            AdvancedListData.addAll(addList);
    }

    public void addItemByPosition(int position, T data) {
        if (position < 0 || position > AdvancedListData.size())
            return;

        if (position == AdvancedListData.size() - 1)
            endAddItem(data);
        //添加数据;
        AdvancedListData.add(position, data);
        //刷新list;
        notifyItemInserted(position);
        notifyItemRangeChanged(position, AdvancedListData.size() - position);
    }

    //在列表末尾添加项目的方法;
    public void endAddItem(T AddModel) {
        AdvancedListData.add(AddModel);
        notifyItemInserted(getItemCount());
    }

    //删除列表中的项目方法;
    public void deleteItem(int position) {
        if (position < getItemCount()) {
            AdvancedListData.remove(position);

            notifyItemRemoved(position);
            //notifyDataSetChanged();

            //如果删除的不是最后一个则需要刷新前面的item;
            if (position != AdvancedListData.size())
                notifyItemRangeChanged(position, AdvancedListData.size() - position);
        }
    }

    /**
     * 删除最后一行数据;
     */
    public void deleteEndData() {
        AdvancedListData.remove(getItemCount() - 1);
        notifyItemRemoved(getItemCount() - 1);
    }

    public void deleteFromToEnd(int position) {
        if (position >= 0 && position < getItemCount()) {
            while (position < AdvancedListData.size()) {
                deleteItem(position);
                position++;
            }
        }
    }

    /**
     * 设置Item是否启用;
     * @param position  位置信息;
     * @param enabled   是否启用;
     */
    public void setItemEnable(int position, boolean enabled) {
        if (position > 0 && position < getItemCount()) {
            T item = AdvancedListData.get(position);
            item.setItemEnable(enabled);
            AdvancedListData.set(position,item);
            //刷新数据;
            notifyItemChanged(position);
        }
    }

    /**
     * 根据Item的ID设置Item是否启用;
     * @param ID
     * @param enabled
     * @return
     */
    public boolean setItemEnableById(int ID, boolean enabled) {
        for (int position = 0; position < AdvancedListData.size(); position++) {
            T itemData = AdvancedListData.get(position);
            if (itemData.getID() == ID) {
                itemData.setItemEnable(enabled);
                AdvancedListData.set(position,itemData);
                //刷新数据;
                notifyItemChanged(position);
                return true;
            }
        }
        return false;
    }

    /**
     * 获取Item的数据
     * @param position  位置信息;
     * @return  数据;
     */
    public T getItemData(int position) {

        if (position >= 0 && position < getItemCount()) {
            return AdvancedListData.get(position);
        } else
            return null;
    }

    /**
     * 通过ID获取Item的数据
     * @param id item的ID;
     * @return   item的数据;
     */
    @Nullable
    public T getItemDataById(int id) {
        for (T data : AdvancedListData) {
            if (data.getID() == id)
                return data;
        }
        return null;
    }

    /**
     * 更改Item的数据;
     * @param position  位置信息;
     * @param data 更新的数据;
     */
    public void changeItemData(int position, T data) {

        if (data == null)
            return;

        if (position >= 0 && position < getItemCount()) {
            AdvancedListData.set(position, data);
            notifyItemChanged(position);
        }
    }

    @SuppressWarnings("unchecked")
    public void setTurnItemButtonChange(int position, boolean checked) {

        if (position >= 0 && position < getItemCount()) {
            int viewType = getItemData(position).getViewType();
            if (viewType == SwitchListItemTypeID || viewType == CheckBoxListItemTypeID || viewType == CheckedTextViewListItemTypeID) {
                TurnViewListItemData data = (TurnViewListItemData) AdvancedListData.get(position);
                data.setButtonStatus(checked);
                AdvancedListData.set(position, (T) data);
                notifyItemChanged(position);
            }
        }
    }

    //Item点击事件的接口;
    public interface OnItemClickListener<T extends AdvanceListModelInterface> {
        void onItemClick(View view, int position,T currentModel);
    }

    //自定义的Item响应事件需要接收OnRecyclerViewItemClickListener接口的方法;
    @SuppressWarnings("unchecked")
    public void setOnItemClickListener(OnItemClickListener<? extends AdvanceListModelInterface> Listener) {
        this.onItemClickListener = (OnItemClickListener<AdvanceListModelInterface>) Listener;
    }

    //Switch和CheckBox被切换时的响应方法;
    public interface OnCheckedChangeListener<VH extends RecyclerView.ViewHolder, T extends AdvanceListModelInterface> {
        void OnCheckedChange(int position, VH holder, T currentModel, int buttonId, CompoundButton buttonView, boolean isChecked);
    }

    @SuppressWarnings("unchecked")
    public void setOnCheckedChangeListener (OnCheckedChangeListener<? extends RecyclerView.ViewHolder, T> Listener) {
        this.onCheckedChangeListener = (OnCheckedChangeListener<RecyclerView.ViewHolder, AdvanceListModelInterface>) Listener;
    }

    public interface OnButtonClickListener<VH extends RecyclerView.ViewHolder, T extends AdvanceListModelInterface> {
        void OnButtonClick(View view, VH holder, int buttonId, int position,T currentModel);
    }

    @SuppressWarnings("unchecked")
    public void setOnButtonClickListener(OnButtonClickListener<? extends RecyclerView.ViewHolder,?> Listener) {
        this.onButtonClickListener = (OnButtonClickListener<RecyclerView.ViewHolder, AdvanceListModelInterface>) Listener;
    }


}
