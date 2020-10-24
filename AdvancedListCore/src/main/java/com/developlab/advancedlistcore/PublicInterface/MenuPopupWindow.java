package com.developlab.advancedlistcore.PublicInterface;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.Adapter.AdvancedListAdapter;
import com.developlab.advancedlistcore.R;

import static com.developlab.advancedlistcore.Utils.SizeUtils.ConversionPositionAdapter;
import static com.developlab.advancedlistcore.Utils.SizeUtils.ConversionSizeDp2Px;

public class MenuPopupWindow extends PopupWindow {

    private Context context;
    private Activity activity;

    private RecyclerView MenuListView;

    /**
     * 构造方法;
     * @param context  上下文;
     */
    public MenuPopupWindow(Context context, Activity activity) {
        super(context);
        this.context = context;
        this.activity = activity;

        //设置边框;
        setBackgroundDrawable(context.getDrawable(R.drawable.view_background_shadow));

        //设置视图;
        View contentView = LayoutInflater.from(context).inflate(R.layout.menu_popwindow_view, null);

        //响应返回键;
        contentView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return keyCode == KeyEvent.KEYCODE_BACK;
            }
        });

        setContentView(contentView);

        //初始化RecyclerView;
        MenuListView = contentView.findViewById(R.id.Menu_Pop_List_ID);
        LinearLayoutManager ListManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        MenuListView.setLayoutManager(ListManager);
    }

    /**
     * 初始化列表
     * @param adapter  浮动菜单Adapter;
     */
    public void setMenuListAdapter(AdvancedListAdapter<? extends AdvanceListModelInterface> adapter) {
        if (adapter != null) {
            MenuListView.setAdapter(adapter);
            ((AdvancedListAdapter<? extends AdvanceListModelInterface>) adapter).notifyDataSetChanged();
        }
    }

    @Override
    public void setWidth(int width_dp) {
        super.setWidth(ConversionSizeDp2Px(context,width_dp));
    }

    @Override
    public void setHeight(int height_dp) {
        super.setHeight(ConversionSizeDp2Px(context,height_dp));
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x_dp, int y_dp) {
        super.showAtLocation(parent, gravity, ConversionSizeDp2Px(context,x_dp), ConversionPositionAdapter(activity,y_dp));
    }

    public void setSizeAndShowAtLocation(View parent, int width_dp, int height_dp, int gravity, int x_dp, int y_dp) {
        setWidth(width_dp);
        setHeight(height_dp);
        showAtLocation(parent,gravity,x_dp,y_dp);
    }

    @Override
    public void showAsDropDown(View anchor, int x_off_dp, int y_off, int gravity) {
        super.showAsDropDown(anchor, ConversionSizeDp2Px(context,x_off_dp), y_off, gravity);
    }

    /**
     * 设置窗口在控件上部;
     * @param parent     视图;
     * @param width_dp   宽度(dp);
     * @param height_dp  高度(dp);
     * @param gravity    与parent位置;
     * @param x_dp       x偏移量(dp);
     * @param y_dp       y偏移量(dp);
     */
    public void setSizeAndShowAsDropUp(View parent, int width_dp, int height_dp, int gravity, int x_dp, int y_dp) {
        setWidth(width_dp);
        setHeight(height_dp);
        getContentView().measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int popHeight = getContentView().getMeasuredHeight();
        showAsDropDown(parent,x_dp,-(popHeight+ ConversionSizeDp2Px(context,y_dp)),gravity);
        Log.e("当前视图高度"+popHeight,"偏移量"+y_dp);
    }

    /**
     * 设置窗口在控件下部;
     * @param parent     视图;
     * @param width_dp   宽度(dp);
     * @param height_dp  高度(dp);
     * @param gravity    与parent位置;
     * @param x_dp       x偏移量(dp);
     * @param y_dp       y偏移量(dp);
     */
    public void setSizeAndShowAsDropDown(View parent, int width_dp, int height_dp, int gravity, int x_dp, int y_dp) {
        setWidth(width_dp);
        setHeight(height_dp);
        showAsDropDown(parent, ConversionSizeDp2Px(context,x_dp), ConversionSizeDp2Px(context,y_dp),gravity);
    }

    @Override
    public void setFocusable(boolean focusable) {
        super.setFocusable(focusable);
    }

    @Override
    public void setOutsideTouchable(boolean touchable) {
        super.setOutsideTouchable(touchable);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

}
