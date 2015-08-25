package friendo.mtel.loyalty.utility;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.preferences.LoyaltyPreference;

/**
 * Created by MTel on 2015/6/26.
 */
public class Utilitys {

    public static boolean isBluetooth(){
//        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//        return bluetoothAdapter.isEnabled();
        return false;
    }

    public static boolean isGPS(Context context){
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (gps || network) {
            return true;
        }
        return false;
    }

    public static Location getLocation(Context context){
        String bestProvider = LocationManager.GPS_PROVIDER;
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        bestProvider = locationManager.getBestProvider(criteria,true);
        Location location = locationManager.getLastKnownLocation(bestProvider);

        return location;
    }

    public static boolean isLogin(Context context){
        String memerID = LoyaltyPreference.getMemberID(context);
        if(memerID.equals("")){
            return false;
        }else{
            return true;
        }
    }

    public static Location locationServiceInital(Context context){
        Location location = null;
        if(isGPS(context)){
            LocationManager lms = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            criteria.setSpeedRequired(true);
            String bestProvider = lms.getBestProvider(criteria, true);
            location = lms.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location == null){
                location = lms.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }
        }
        return location;
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }


    public static int getTodayWeekDay(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

}
