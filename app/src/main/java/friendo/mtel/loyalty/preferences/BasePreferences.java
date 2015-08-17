package friendo.mtel.loyalty.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import friendo.mtel.loyalty.common.CommonData;

/**
 * Created by MTel on 2015/8/12.
 */
public class BasePreferences {
    private static String TAG = BasePreferences.class.getSimpleName();

    protected static SharedPreferences settings;
    protected static SharedPreferences.Editor editor;
    protected static Context appcontext;

    /**
     *
     * @param context
     */
    public static void load(Context context){
        try {
            appcontext = context;
            load();
        }catch (Exception e){
            Log.e(TAG,"Exception:" +e);
        }
    }


    /**
     *
     */
    public static void load(){
        try{
            if(appcontext != null){
                settings = appcontext.getSharedPreferences(CommonData.PREFERENCES_PREF_NAME,0);
                editor = settings.edit();
            }
        }catch (Exception e){
            Log.e(TAG,"Exception:" +e);
        }
    }

    /**
     *
     */
    public static void clear(){
        try{
            if(appcontext != null){
                settings = appcontext.getSharedPreferences(CommonData.PREFERENCES_PREF_NAME,0);
                editor = settings.edit();
                editor.clear();
                editor.commit();
            }
        }catch (Exception e){
            Log.e(TAG,"Exception:" +e);
        }
    }

    /**
     *
     * @return
     */
    public static boolean save(){
        try{
            return editor.commit();
        }catch (Exception e){
            Log.e(TAG,"Exception:" +e);
        }
        return false;
    }
}
