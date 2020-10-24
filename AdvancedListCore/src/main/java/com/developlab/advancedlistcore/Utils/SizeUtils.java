package com.developlab.advancedlistcore.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;

public class SizeUtils {

    /**
     * 尺寸dp转换为px;
     * @param context  上下文;
     * @param dpValue  dp尺寸;
     * @return         px尺寸;
     */
    public static int ConversionSizeDp2Px(Context context, int dpValue) {
        if (dpValue == ViewGroup.LayoutParams.WRAP_CONTENT || dpValue == ViewGroup.LayoutParams.MATCH_PARENT)
            return dpValue;

        Resources resources = context.getResources();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, resources.getDisplayMetrics());
    }

    /**
     * 位置dp转换为px;
     * @param activity
     * @param dp
     * @return
     */
    public static int ConversionPositionAdapter(Activity activity, int dp) {
        Resources resources = activity.getResources();
        int NavBarSize = getNavigationBarHeight(activity);
        int Position = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());

        if (NavBarSize != 0)
            return NavBarSize + Position;
        else
            return Position;
    }

    /**
     * 获取虚拟导航栏的高度;
     * @param activity
     * @return
     */
    public static int getNavigationBarHeight(Activity activity) {
        int result = 0;
        Resources resources = activity.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0 && checkHasNavigationBar(activity)) {
            result = resources.getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 判断是否存在虚拟导航栏;
     * @param activity
     * @return
     */
    public static boolean checkHasNavigationBar(Activity activity) {
        WindowManager windowManager = activity.getWindowManager();
        Display d = windowManager.getDefaultDisplay();

        DisplayMetrics realDisplayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            d.getRealMetrics(realDisplayMetrics);
        }

        int realHeight = realDisplayMetrics.heightPixels;
        int realWidth = realDisplayMetrics.widthPixels;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        d.getMetrics(displayMetrics);

        int displayHeight = displayMetrics.heightPixels;
        int displayWidth = displayMetrics.widthPixels;

        return (realWidth - displayWidth) > 0 || (realHeight - displayHeight) > 0;
    }
}
