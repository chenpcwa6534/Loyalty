package friendo.mtel.loyalty.application;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;

import java.util.LinkedList;
import java.util.List;

import friendo.mtel.loyalty.data.DataManager;

/**
 * Created by MTel on 2015/7/24.
 */
public class MainApp extends Application {
    private String TAG = MainApp.class.getSimpleName();

    private List<Activity> activityList = new LinkedList<Activity>();
    private static MainApp instance;

    public void addActivity(Activity activity){ activityList.add(activity);}

    public void exit(){
        for(Activity activity:activityList){
            activity.finish();
        }
        System.exit(0);
    }

    public static MainApp get(){ return instance; }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initApp();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


    private void initApp(){
        try{
            DataManager.getInstance(getApplicationContext());
        }catch (Exception e){

        }
    }
}
