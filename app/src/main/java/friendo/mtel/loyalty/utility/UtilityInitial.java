package friendo.mtel.loyalty.utility;

import android.app.Activity;

import friendo.mtel.loyalty.R;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by MTel on 2015/7/24.
 */
public class UtilityInitial  {

    public static int[] welcomeDraw = new int[]{R.mipmap.tutorial_p1,R.mipmap.tutorial_p2,R.mipmap.tutorial_p3,R.mipmap.tutorial_p4,R.mipmap.tutorial_p5};

    public static int[] tabIcon_press = new int[] {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    public static int[] tabIcon_pressed = new int[] {R.mipmap.ic_message,R.mipmap.ic_message,R.mipmap.ic_message,R.mipmap.ic_message};

    public static int[] frontTabIcon_press = new int[]{R.mipmap.btn_common_white_kind_normal,R.mipmap.btn_common_white_kind_normal,R.mipmap.btn_common_white_kind_normal};
    public static int[] frontTabIcon_pressed = new int[]{R.mipmap.btn_common_white_kind_pressed,R.mipmap.btn_common_white_kind_pressed,R.mipmap.btn_common_white_kind_pressed};

    public static String[] tabTitle(Context context){
        String[] tabTitle = new String[] {context.getResources().getString(R.string.store), context.getResources().getString(R.string.preferential), context.getResources().getString(R.string.pocket), context.getResources().getString(R.string.more) };
        return tabTitle;
    }

    public static String[] frontTabTitle(Context context){
        String[] tabTitle = new String[] {context.getResources().getString(R.string.subfront_preferential), context.getResources().getString(R.string.subfront_pointcare), context.getResources().getString(R.string.subfront_information) };
        return tabTitle;
    }

}
