package com.developlab.advancedlistcore.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.developlab.advancedlistcore.R;

public class DropDetailViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout itemClick;
    private LinearLayout DropView;
    private ImageView ShowDetailBtn;
    public TextView ItemText;
    public TextView DetailText;
    public Button DetailButton;  //Detail中的按钮;

    private boolean dropOn;

    public DropDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        itemClick = itemView.findViewById(R.id.Click_Item_Drop_ViewID);
        DropView = itemView.findViewById(R.id.Click_Item_Drop_DetailView);
        ShowDetailBtn = itemView.findViewById(R.id.Click_Item_Drop_ImageView);
        ItemText = itemView.findViewById(R.id.Click_Item_Drop_TitleText);
        DetailText = itemView.findViewById(R.id.Click_Item_Drop_DetailText);
    }

    public void setDropView(boolean show) {
        dropOn = show;
        if (dropOn) {
            DropView.setVisibility(View.VISIBLE);
            ShowDetailBtn.animate().rotation(180);
        } else {
            DropView.setVisibility(View.GONE);
            ShowDetailBtn.animate().rotation(90);
        }
    }

    public void switchDropView() {
        if (dropOn) {

            DropView.setVisibility(View.GONE);

//            TranslateAnimation hideAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
//                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, -1.0f);
//            hideAnim.setDuration(300);
//            DropView.startAnimation(hideAnim);
//            hideAnim.setAnimationListener(new Animation.AnimationListener() {
//                @Override
//                public void onAnimationStart(Animation animation) {
//
//                }
//
//                @Override
//                public void onAnimationEnd(Animation animation) {
//                    DropView.setVisibility(View.GONE);
//                }
//
//                @Override
//                public void onAnimationRepeat(Animation animation) {
//
//                }
//            });

            ShowDetailBtn.animate().rotation(90);
            dropOn = false;
        } else {

//            TranslateAnimation showAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
//                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
//            showAnim.setDuration(300);
//            DropView.startAnimation(showAnim);

            DropView.setVisibility(View.VISIBLE);
            ShowDetailBtn.animate().rotation(180);
            dropOn = true;
        }

    }
}
