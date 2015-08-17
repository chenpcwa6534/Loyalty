package com.astuetz.utility;

import android.content.Context;
import android.util.Log;
import android.util.Patterns;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by MTel on 2015/6/30.
 */
public class PicassoUtility {

    private static String TAG = PicassoUtility.class.getSimpleName();

    public static boolean load(Context context,ImageView view, String imgUrl){
        try{
            if(isValidUrl(imgUrl)){
                Picasso.with(context)
                        .load(imgUrl)
                        .into(view);
                return true;
            }
        }catch(Exception e){
            Log.e(TAG,e.getMessage());
        }
        return false;
    }


    private static boolean isValidUrl(String imgUrl){
        if(imgUrl.isEmpty())
            return false;
        if(!Patterns.WEB_URL.matcher(imgUrl).matches())
            return false;
        return true;
    }
}
